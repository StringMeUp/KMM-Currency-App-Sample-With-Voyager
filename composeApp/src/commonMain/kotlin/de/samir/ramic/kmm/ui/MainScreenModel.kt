package de.samir.ramic.kmm.ui

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

    private var _currencies = MutableStateFlow<List<CurrencyDto>>(listOf())
    var currencies: StateFlow<List<CurrencyDto>> = _currencies.stateIn(
        screenModelScope, SharingStarted.WhileSubscribed(5000L), initialValue = listOf()
    )

    private var _displayedCurrencies = MutableStateFlow<List<CurrencyDto>>(listOf())
    var displayedCurrencies: StateFlow<List<CurrencyDto>> = _currencies.stateIn(
        screenModelScope, SharingStarted.WhileSubscribed(5000L), initialValue = listOf()
    )

    init {
        getCurrencies()
    }


    private fun getCurrencies() {
        screenModelScope.launch {
            val resultCurrency = repository.getCurrency()
            resultCurrency.onSuccess {
                _currencies.value = it.data.allCurrencies
                _displayedCurrencies.value = it.data.allCurrencies.filter { it.code == "EUR" }
                println("Success: $it")
            }
            resultCurrency.onFailure { println("Error: ${it.message}") }
        }
    }

    private fun convertAll(value: Double) {
       val updated =  _displayedCurrencies.value.map { (code, value) ->

        }
    }
}
