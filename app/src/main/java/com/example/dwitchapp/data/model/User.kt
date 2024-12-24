package com.example.dwitchapp.data.model

import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class UsersPermissionsUser (
    val id: Long? = null,
    val documentID: String? = null,
    val username: String? = null,
    val email: String? = null,
    val provider: String? = null,
    val confirmed: Boolean? = null,
    val blocked: Boolean? = null,
    val createdAt: String? = null,
    val updatedAt: String? = null,
    val publishedAt: String? = null
)