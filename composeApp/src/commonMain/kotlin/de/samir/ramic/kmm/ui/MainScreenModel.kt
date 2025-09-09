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
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class MainScreenModel(private val repository: Repository) : ScreenModel {

    @Stable
    class CurrencyState(
        val currencies: List<CurrencyDto> = listOf()
    ) {
        var sourceValue by mutableStateOf(CurrencyDto("USD", 0.0))
        var targetValue by mutableStateOf(CurrencyDto("EUR", 0.0))
        private var sourceConversionValue by mutableStateOf<Double?>(null)
        private var targetConversionValue by mutableStateOf<Double?>(null)

        var sourceInputText by mutableStateOf("")
        var targetInputText by mutableStateOf("")

        fun setSource(source: String) {
            sourceInputText = source
        }

        fun setTarget(target: String) {
            targetInputText = target
        }

        fun convertSourceToTarget() {
            if (sourceInputText.isEmpty()) setTarget("")
            val amount = sourceInputText.toDoubleOrNull() ?: return

            targetConversionValue = if (sourceValue.code == "USD") {
                amount * targetValue.value
            } else {
                val rate = targetValue.value / sourceValue.value
                amount * rate
            }

            val bdV = BigDecimal.fromDouble(targetConversionValue ?: 0.0)
            val scaled = bdV.roundToDigitPositionAfterDecimalPoint(4, RoundingMode.ROUND_HALF_AWAY_FROM_ZERO)
            setTarget(scaled.toPlainString())
        }


        fun convertTargetToSource() {
            val amount = targetInputText.toDoubleOrNull() ?: return

            sourceConversionValue = if (targetValue.code == "USD") {
                amount * sourceValue.value
            } else {
                val rate = sourceValue.value / targetValue.value
                amount * rate
            }

            val bdV = BigDecimal.fromDouble(sourceConversionValue ?: 0.0)
            val scaled = bdV.roundToDigitPositionAfterDecimalPoint(4, RoundingMode.ROUND_HALF_AWAY_FROM_ZERO)
            setSource(scaled.toPlainString())
        }

        fun swap() {
            val temp = sourceValue
            sourceValue = targetValue
            targetValue = temp

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
        screenModelScope.launch {
            val resultCurrencies = repository.getCurrencies()
            resultCurrencies.onSuccess { responseDto ->
                val updated = CurrencyState(responseDto.data.allCurrencies).also {
                    it.sourceValue = it.currencies.first()
                    it.targetValue = it.currencies.find { it.code == "EUR" } ?: it.currencies.last()
                }

                _currencyState.value = updated
                println("Success: $responseDto")
            }
            resultCurrencies.onFailure { println("Error: ${it.message}") }
        }
    }
}
