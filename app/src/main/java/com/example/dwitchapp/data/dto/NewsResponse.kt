package com.example.dwitchapp.data.dto

import com.example.dwitchapp.data.model.news.News
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NewsResponse (
    val data: List<News>
)