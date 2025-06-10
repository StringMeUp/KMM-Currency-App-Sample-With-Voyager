package de.samir.ramic.kmm.data.repository

import de.samir.ramic.kmm.data.model.CurrencyResponseDto
import de.samir.ramic.kmm.data.RequestHandler
import de.samir.ramic.kmm.data.api.ApiService
import de.samir.ramic.kmm.domain.repository.Repository


class RepositoryImpl(
    private val requestHandler: RequestHandler,
    private val apiService: ApiService
) : Repository {

    override suspend fun getCurrency(): Result<CurrencyResponseDto> {
        return requestHandler.makeSafeApiCall {
            apiService.getCurrency()
        }
    }
}