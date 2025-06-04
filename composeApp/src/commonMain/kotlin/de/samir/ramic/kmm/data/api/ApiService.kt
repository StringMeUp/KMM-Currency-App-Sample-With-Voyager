package de.samir.ramic.kmm.data.api

import de.samir.ramic.kmm.data.CurrencyResponseDto

interface ApiService {
    suspend fun getCurrency(): CurrencyResponseDto
}