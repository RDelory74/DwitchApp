package com.example.dwitchapp.viewmodel

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

sealed class MyUiState<out T> {
    data object Idle : MyUiState<Nothing>()
    data object Loading : MyUiState<Nothing>()
    data class Error(val error: Exception?) : MyUiState<Nothing>()
    data class Success<T>(val data: T?) : MyUiState<T>()
    data object Empty : MyUiState<Nothing>()
}

class UiStateHandler<T> {
    private val _state = MutableStateFlow<MyUiState<T>>(MyUiState.Idle)
    val state: StateFlow<MyUiState<T>> = _state

    fun setLoading() {
        _state.value = MyUiState.Loading
    }

    fun setSuccess(data: T?) {
        _state.value = if (data == null || (data is Collection<*> && data.isEmpty())) {
            MyUiState.Empty
        } else {
            MyUiState.Success(data)
        }
    }

    fun setError(exception: Exception?) {
        _state.value = MyUiState.Error(exception)
    }

    fun setIdle() {
        _state.value = MyUiState.Idle
    }
}