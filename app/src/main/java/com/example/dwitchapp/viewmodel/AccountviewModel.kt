package com.example.dwitchapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dwitchapp.BuildConfig
import com.example.dwitchapp.service.DwitchServiceFactory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import com.example.dwitchapp.data.dto.User
import com.example.dwitchapp.data.model.Order
import com.example.dwitchapp.service.LoginRequest

class AccountviewModel: ViewModel() {
    private val uiStateHandler = UiStateHandler<List<Order>>()
    val uiState = uiStateHandler.state

    private val _refreshKey = MutableStateFlow(0)
    private var user: User? = null

    init {
        fetchOrders()
    }
    fun refresh() {
        _refreshKey.value += 1
    }

    fun login(username: String, password: String) {
        viewModelScope.launch {
            try {
                val request = LoginRequest(username, password)
                val response = DwitchServiceFactory.dwitchService.login(request)
                user = response.user  // Je me demande si je dois faire une classe avec un val data qui aurai un user
                Timber.d("Login successful: $user")
                fetchOrders() // Si le user est bon on fetchs ses commandes
            } catch (e: Exception) {
                Timber.d("Error logging in: ${e.message}")
            }
        }
    }


    private fun fetchOrders() {
        viewModelScope.launch {
            uiStateHandler.setLoading()
            try {
                val jwt = user?.jwt ?: throw IllegalStateException("User not authenticated")
                val response = DwitchServiceFactory.dwitchService.getOrders("Bearer $jwt")
//                val strapiApiKey = BuildConfig.apiKey
//                val response = DwitchServiceFactory.dwitchService.getOrders("Bearer $strapiApiKey")
                uiStateHandler.setSuccess(response.data)
                Timber.d("$response")
            } catch (e: Exception) {
                uiStateHandler.setError(e)
                Timber.d("Error fetching news: ${e.message}")
            }
        }
    }
}
