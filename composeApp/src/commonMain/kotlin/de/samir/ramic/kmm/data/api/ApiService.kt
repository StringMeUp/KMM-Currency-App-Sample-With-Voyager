package de.samir.ramic.kmm.data.api

import de.samir.ramic.kmm.data.model.CurrencyResponseDto

interface ApiService {
    suspend fun getCurrencies(): CurrencyResponseDto
}