package de.samir.ramic.kmm.ui

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
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
            val amount = sourceInputText.toDoubleOrNull() ?: return

            targetConversionValue = if (sourceValue.code == "USD") {
                amount * targetValue.value
            } else {
                val rate = targetValue.value / sourceValue.value
                amount * rate
            }

            setTarget(targetConversionValue.toString())
        }


        fun convertTargetToSource() {
            val amount = targetInputText.toDoubleOrNull() ?: return

            sourceConversionValue = if (targetValue.code == "USD") {
                amount * sourceValue.value
            } else {
                val rate = sourceValue.value / targetValue.value
                amount * rate
            }

            setSource(sourceConversionValue.toString())
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
