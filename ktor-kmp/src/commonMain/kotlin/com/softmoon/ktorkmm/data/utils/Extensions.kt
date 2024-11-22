package com.softmoon.ktorkmm.data.utils

import com.softmoon.ktorkmm.data.remote.NetworkLogLevel
import io.ktor.client.plugins.logging.*

fun NetworkLogLevel.getLogLevel(): LogLevel? = mapOf(
    NetworkLogLevel.ALL to LogLevel.ALL,
    NetworkLogLevel.BODY to LogLevel.BODY,
    NetworkLogLevel.INFO to LogLevel.INFO,
    NetworkLogLevel.HEADERS to LogLevel.HEADERS,
    NetworkLogLevel.NONE to LogLevel.NONE
)[this]