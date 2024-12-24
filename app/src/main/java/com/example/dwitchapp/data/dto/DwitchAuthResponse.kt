package com.example.dwitchapp.data.dto

import com.example.dwitchapp.data.model.UsersPermissionsUser
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class User(
    val user:UsersPermissionsUser? = null,
    val jwt: String? = null
)



