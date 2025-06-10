package de.samir.ramic.kmm.domain.repository

import de.samir.ramic.kmm.data.model.CurrencyResponseDto

interface Repository {
    suspend fun getCurrency(): Result<CurrencyResponseDto>
}