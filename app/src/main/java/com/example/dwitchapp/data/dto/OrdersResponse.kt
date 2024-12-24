package com.example.dwitchapp.data.dto

import com.example.dwitchapp.data.model.Order
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class OrdersResponse(
    val data: List<Order>
)