package com.softmoon.ktorkmm.data.services

import com.softmoon.ktorkmm.data.remote.NetworkClientProvider
import io.ktor.client.*

abstract class BaseService(private val networkClientProvider: NetworkClientProvider) {
    val client: HttpClient
        get() = networkClientProvider.getClient()
}