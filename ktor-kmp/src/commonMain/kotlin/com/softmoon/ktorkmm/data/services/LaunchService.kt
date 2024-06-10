package com.softmoon.ktorkmm.data.services

import com.softmoon.ktorkmm.data.response.Launch
import com.softmoon.ktorkmm.ktorHttpClient
import io.ktor.client.call.*
import io.ktor.client.request.*

internal class LaunchService {
    private val client = ktorHttpClient

    suspend fun getLaunches(): ArrayList<Launch> {
        val response = client.get("https://api.spacexdata.com/v5/launches")
        return response.body()
    }
}