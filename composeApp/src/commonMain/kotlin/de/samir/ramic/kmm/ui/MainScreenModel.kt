package de.samir.ramic.kmm.ui

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import de.samir.ramic.kmm.data.model.CurrencyData
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

    init {
        callApi()
    }


    private fun callApi() {
        screenModelScope.launch {
            val resultCurrency = repository.getCurrency()
            resultCurrency.onSuccess {
                _currencies.value = it.data.allCurrencies
                println("Success: $it")
            }
            resultCurrency.onFailure { println("Error: ${it.message}") }
        }
    }
}
