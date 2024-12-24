package com.example.dwitchapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dwitchapp.BuildConfig
import com.example.dwitchapp.service.DwitchServiceFactory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import com.example.dwitchapp.data.dto.OrdersResponse
import com.example.dwitchapp.data.model.Order

class AccountviewModel: ViewModel() {
    private val uiStateHandler = UiStateHandler<List<Order>>()
    val uiState = uiStateHandler.state

    private val _refreshKey = MutableStateFlow(0)

    init {
        fetchOrders()
    }
    fun refresh() {
        _refreshKey.value += 1
    }

    private fun fetchOrders() {
        viewModelScope.launch {
            uiStateHandler.setLoading()
            try {
                val strapiApiKey = BuildConfig.apiKey
                val response = DwitchServiceFactory.dwitchService.getOrders("Bearer $strapiApiKey")
                uiStateHandler.setSuccess(response.data)
                Timber.d("$response")
            } catch (e: Exception) {
                uiStateHandler.setError(e)
                Timber.d("Error fetching news: ${e.message}")
            }
        }
    }
}
