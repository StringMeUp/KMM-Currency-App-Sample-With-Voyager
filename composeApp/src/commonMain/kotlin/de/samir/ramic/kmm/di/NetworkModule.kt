package de.samir.ramic.kmm.di

import de.samir.ramic.kmm.HttpClientProvider
import de.samir.ramic.kmm.data.RequestHandler
import de.samir.ramic.kmm.data.api.ApiService
import de.samir.ramic.kmm.data.api.ApiServiceImpl
import de.samir.ramic.kmm.data.endpoint.Environment
import de.samir.ramic.kmm.getHttpClientProvider
import io.ktor.client.HttpClient
import org.koin.dsl.module

val networkModule = module {
    single { RequestHandler() }
    single { getHttpClientProvider() }
    single<HttpClient> {
        val env: Environment = get()
        val provider: HttpClientProvider = get()
        provider.getClient(env)
    }
    single<ApiService> {
        val client: HttpClient = get()
        ApiServiceImpl(client)
    }
}