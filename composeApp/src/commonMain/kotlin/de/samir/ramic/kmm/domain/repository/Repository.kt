package de.samir.ramic.kmm.domain.repository

import de.samir.ramic.kmm.data.CurrencyResponseDto

interface Repository {
    suspend fun getCurrency(): Result<CurrencyResponseDto>
}