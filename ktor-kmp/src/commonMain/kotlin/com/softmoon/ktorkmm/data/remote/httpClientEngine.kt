package com.softmoon.ktorkmm.data.remote

import io.ktor.client.engine.*

expect fun provideHttpEngine(): HttpClientEngineFactory<*>