package de.samir.ramic.kmm.ui

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import de.samir.ramic.kmm.domain.repository.Repository
import kotlinx.coroutines.launch

class MainScreenModel(private val repository: Repository) : ScreenModel {

    init {
        callApi()
    }

    private fun callApi() {
        screenModelScope.launch {
            val resultCurrency = repository.getCurrency()
            resultCurrency.onSuccess { println("Success: $it") }
            resultCurrency.onFailure { println("Error: ${it.message}") }
        }
    }
}
