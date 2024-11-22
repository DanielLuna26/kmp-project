package com.softmoon.ktorkmm.data.services

import com.softmoon.ktorkmm.data.remote.KtorHttpClient
import com.softmoon.ktorkmm.data.remote.NetworkClientProvider
import com.softmoon.ktorkmm.data.remote.NetworkLogLevel
import com.softmoon.ktorkmm.data.response.Launch
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise
import kotlin.js.Promise

@JsExport
object LaunchServiceWrapper {
    private val client = KtorHttpClient.Builder()
        .baseUrl("https://api.spacexdata.com")
        .enableLogs(NetworkLogLevel.ALL)
        .build()
    private val networkClientProvider = NetworkClientProvider.create(client)

    private val launchService = LaunchService(networkClientProvider)

    fun getLaunches(): Promise<Array<Launch>> = GlobalScope.promise {
        launchService.getLaunches().toTypedArray()
    }
}