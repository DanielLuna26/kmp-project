package com.softmoon.ktorkmm.data.remote

import com.softmoon.ktorkmm.data.utils.getLogLevel
import io.ktor.client.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class NetworkClientProvider private constructor(
    private val client: HttpClient
) {
    companion object {
        fun create(client: KtorHttpClient): NetworkClientProvider {
            HttpClient(client.engine) {
                install(ContentNegotiation) {
                    json(
                        Json {
                            ignoreUnknownKeys = true
                            isLenient = true
                        }
                    )
                }
                install(HttpTimeout) {
                    requestTimeoutMillis = client.timeout
                }
                install(Logging) {
                    logger = Logger.SIMPLE
                    level = client.networkLogLevel.getLogLevel() ?: LogLevel.NONE
                }
                defaultRequest {
                    url(client.baseUrl)
                }
                expectSuccess = true
            }.also { httpClient ->
                return NetworkClientProvider(httpClient)
            }
        }
    }

    fun getClient(): HttpClient = client
}