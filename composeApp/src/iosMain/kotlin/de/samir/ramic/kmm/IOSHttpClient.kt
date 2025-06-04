package de.samir.ramic.kmm

import de.sam.kmp.starter.data.remote.endpoint.HttpConstants
import de.samir.ramic.kmm.data.endpoint.Environment
import io.ktor.client.HttpClient
import io.ktor.client.engine.darwin.Darwin
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class IOSHttpClient : HttpClientProvider {
    override fun getClient(env: Environment): HttpClient {
        return HttpClient(Darwin) {

            install(Logging) {
                logger = Logger.SIMPLE
                level = LogLevel.ALL
            }

            install(ContentNegotiation) {
                json(Json { ignoreUnknownKeys = true })
            }

            defaultRequest {
                println("📡 iOS DefaultRequest triggered!")
                url {
                    protocol = URLProtocol.HTTPS
                    host = env.baseUrl
                    parameters.append(HttpConstants.API_KEY, getApiKey())
                }
            }
        }
    }
}