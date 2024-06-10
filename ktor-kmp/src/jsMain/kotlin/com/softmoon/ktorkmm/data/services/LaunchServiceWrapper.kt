package com.softmoon.ktorkmm.data.services

import com.softmoon.ktorkmm.data.response.Launch
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise
import kotlin.js.Promise

@JsExport
object LaunchServiceWrapper {
    private val launchService = LaunchService()

    fun getLaunches(): Promise<Array<Launch>> = GlobalScope.promise {
        launchService.getLaunches().toTypedArray()
    }
}