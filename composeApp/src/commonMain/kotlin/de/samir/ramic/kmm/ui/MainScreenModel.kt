package de.samir.ramic.kmm.ui

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.ionspin.kotlin.bignum.decimal.BigDecimal
import com.ionspin.kotlin.bignum.decimal.RoundingMode
import de.samir.ramic.kmm.data.model.CurrencyDto
import de.samir.ramic.kmm.domain.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.datetime.format

class MainScreenModel(private val repository: Repository) : ScreenModel {

    @Stable
    class CurrencyState(
        val currencies: List<CurrencyDto> = listOf()
    ) {
        var sourceCurrencyCode by mutableStateOf(CurrencyDto("USD", 0.0))
        var targetCurrencyCode by mutableStateOf(CurrencyDto("EUR", 0.0))
        private var sourceConversionValue by mutableStateOf<Double?>(null)
        private var targetConversionValue by mutableStateOf<Double?>(null)

        var sourceInputText by mutableStateOf("")
        var targetInputText by mutableStateOf("")
        var lastUpdatedAt by mutableStateOf("")

        fun setSource(source: String) {
            sourceInputText = source
        }

        fun setTarget(target: String) {
            targetInputText = target
        }

        fun convertSourceToTarget() {
            if (sourceInputText.isEmpty()) setTarget("")
            val amount = sourceInputText.toDoubleOrNull() ?: return

            targetConversionValue = if (sourceCurrencyCode.code == "USD") {
                amount * targetCurrencyCode.value
            } else {
                val rate = targetCurrencyCode.value / sourceCurrencyCode.value
                amount * rate
            }

            val bdV = BigDecimal.fromDouble(targetConversionValue ?: 0.0)
            val scaled = bdV.roundToDigitPositionAfterDecimalPoint(4, RoundingMode.ROUND_HALF_AWAY_FROM_ZERO)
            setTarget(scaled.toPlainString())
        }


        fun convertTargetToSource() {
            val amount = targetInputText.toDoubleOrNull() ?: return

            sourceConversionValue = if (targetCurrencyCode.code == "USD") {
                amount * sourceCurrencyCode.value
            } else {
                val rate = sourceCurrencyCode.value / targetCurrencyCode.value
                amount * rate
            }

            val bdV = BigDecimal.fromDouble(sourceConversionValue ?: 0.0)
            val scaled = bdV.roundToDigitPositionAfterDecimalPoint(4, RoundingMode.ROUND_HALF_AWAY_FROM_ZERO)
            setSource(scaled.toPlainString())
        }

        fun swap() {
            val temp = sourceCurrencyCode
            sourceCurrencyCode = targetCurrencyCode
            targetCurrencyCode = temp

            val tempSourceText = sourceInputText
            sourceInputText = targetInputText
            targetInputText = tempSourceText
        }
    }

    private var _currencyState = MutableStateFlow(CurrencyState())
    var currencyState: StateFlow<CurrencyState> = _currencyState.stateIn(
        screenModelScope, SharingStarted.WhileSubscribed(5000L), initialValue = CurrencyState()
    )

    init {
        getCurrencies()
    }

    private fun getCurrencies() {
        screenModelScope.launch(Dispatchers.IO) {
            val resultCurrencies = repository.getCurrencies()
            resultCurrencies.onSuccess { responseDto ->
                val updated = CurrencyState(responseDto.data.allCurrencies).also {
                    it.sourceCurrencyCode = it.currencies.first()
                    it.targetCurrencyCode = it.currencies.find { it.code == "EUR" } ?: it.currencies.last()
                    it.lastUpdatedAt = responseDto.meta.formattedUpdateTime
                }

                _currencyState.value = updated
                println("Success: $responseDto")
            }
            resultCurrencies.onFailure { println("Error: ${it.message}") }
        }
    }
}
