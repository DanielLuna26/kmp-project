package com.softmoon.ktorkmm.data.remote

import io.ktor.client.engine.HttpClientEngineFactory

class KtorHttpClient private constructor(
    val engine: HttpClientEngineFactory<*>,
    val baseUrl: String,
    val timeout: Long,
    val networkLogLevel: NetworkLogLevel
) {

    class Builder {
        private val engine: HttpClientEngineFactory<*> = provideHttpEngine()
        private var baseUrl: String = ""
        private var timeout: Long = 10_000
        private var networkLogLevel: NetworkLogLevel = NetworkLogLevel.NONE

        fun baseUrl(baseUrl: String) = apply {
            this.baseUrl = baseUrl
        }

        fun setTimeout(timeout: Long) = apply {
            this.timeout = timeout
        }

        fun enableLogs(networkLogLevel: NetworkLogLevel) = apply {
            this.networkLogLevel = networkLogLevel
        }

        fun build() = KtorHttpClient(engine, baseUrl, timeout, networkLogLevel)
    }
}