package de.samir.ramic.kmm.ui

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import de.samir.ramic.kmm.domain.repository.Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainScreenModel(private val repository: Repository) : ScreenModel {

    private val _counter = MutableStateFlow(0)
    val counter: StateFlow<Int> = _counter

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

    fun increment() {
        _counter.value++
    }

    fun decrement() {
        _counter.value--
    }

    override fun onDispose() {
        super.onDispose()
    }
}
