package com.softmoon.ktorkmm.data.remote

import io.ktor.client.engine.*
import io.ktor.client.engine.js.*

actual fun provideHttpEngine(): HttpClientEngineFactory<*> = Js