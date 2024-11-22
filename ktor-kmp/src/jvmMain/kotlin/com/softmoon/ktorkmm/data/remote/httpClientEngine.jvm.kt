package com.softmoon.ktorkmm.data.remote

import io.ktor.client.engine.*
import io.ktor.client.engine.okhttp.*

actual fun provideHttpEngine(): HttpClientEngineFactory<*> = OkHttp