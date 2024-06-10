package com.softmoon.ktorkmm.data.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

@OptIn(ExperimentalJsExport::class)
@Serializable
@JsExport
data class Launch(
    @SerialName("date_utc")
    val date: String?,
    val details: String?,
    @SerialName("flight_number")
    val flightNumber: Int?,
    val id: String?,
    val launchpad: String?,
    val rocket: String?,
    val ships: Array<String>?,
    val success: Boolean?,
    val window: Int?
)