package com.example.dwitchapp.data.model.news

import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
    data class News(
        val id: Int,
        val documentId: String,
        val title: String,
        val content: String,
        val createdAt: String,
        val updatedAt: String,
        val publishedAt: String,
        val medias: List<Media>? = null
    )
