package com.example.dwitchapp.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dwitchapp.BuildConfig
import com.example.dwitchapp.data.model.news.News
import com.example.dwitchapp.service.DwitchServiceFactory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber

class NewsViewModel : ViewModel() {
    private val uiStateHandler = UiStateHandler<List<News>>()
    val uiState = uiStateHandler.state

    private val _refreshKey = MutableStateFlow(0)

    init {
        fetchNews()
    }
    fun refresh() {
        _refreshKey.value += 1
    }
   private fun fetchNews() {
        viewModelScope.launch {
            uiStateHandler.setLoading()
            try {
                val strapiApiKey = BuildConfig.apiKey
                val response = DwitchServiceFactory.dwitchService.getNews("Bearer $strapiApiKey")
                uiStateHandler.setSuccess(response.data)
                Timber.d("$response")
            } catch (e: Exception) {
                uiStateHandler.setError(e)
                Timber.d("Error fetching news: ${e.message}")
            }
        }
    }
}

//suspend fun fetchNews(): List<News>? {
//    try {
//
//        val newsList = response.data
//        return newsList
//    } catch (e: Exception) {
//        // handle error - at the moment we just print
//        Timber.d("Error fetching orders: ${e.message}")
//        return null
//    }
//}