package de.samir.ramic.kmm

import de.samir.ramic.kmm.data.endpoint.Environment
import io.ktor.client.HttpClient

interface Platform {
    val name: String
}

interface HttpClientProvider {
    fun getClient(env: Environment): HttpClient
}

expect fun getPlatform(): Platform

expect fun getHttpClientProvider(): HttpClientProvider

expect fun getApiKey(): String
