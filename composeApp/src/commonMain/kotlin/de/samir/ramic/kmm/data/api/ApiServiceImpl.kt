package de.samir.ramic.kmm.data.api

import de.samir.ramic.kmm.data.endpoint.Endpoint
import de.samir.ramic.kmm.data.model.CurrencyResponseDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ApiServiceImpl(private val client: HttpClient) : ApiService {

    override suspend fun getCurrencies(): CurrencyResponseDto {
       return client.get(Endpoint.CURRENCY_LATEST).body()
    }
}