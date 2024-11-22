package com.softmoon.ktorkmm.data.services

import com.softmoon.ktorkmm.data.remote.NetworkClientProvider
import com.softmoon.ktorkmm.data.response.Launch
import io.ktor.client.call.*
import io.ktor.client.request.*

class LaunchService(
    private val networkClientProvider: NetworkClientProvider
): BaseService(networkClientProvider) {

    suspend fun getLaunches(): ArrayList<Launch> {
        val response = client.get("/v5/launches")
        return response.body()
    }
}