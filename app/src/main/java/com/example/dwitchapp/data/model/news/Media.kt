package com.example.dwitchapp.data.model.news

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Media(
    val id: Int,
    val name: String,
    val url: String,
)