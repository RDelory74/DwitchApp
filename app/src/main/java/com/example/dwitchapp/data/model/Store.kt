package com.example.dwitchapp.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Store (
    val id: Long? = null,
    val documentID: String? = null,
    val name: String? = null,
    val isOpen: Boolean? = null,
    val city: String? = null,
    val zipCode: String? = null,
    val createdAt: String? = null,
    val updatedAt: String? = null,
    val publishedAt: String? = null
)