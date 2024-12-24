package com.example.dwitchapp.ui.screens


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

import com.example.dwitchapp.data.model.Order

import com.example.dwitchapp.ui.component.AppBottomBar

import com.example.dwitchapp.ui.component.OrderList
import com.example.dwitchapp.viewmodel.AccountviewModel
import com.example.dwitchapp.viewmodel.MyUiState

import timber.log.Timber

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(refreshKey: Int, navController: NavController) {
    val viewModel: AccountviewModel = viewModel()
    val state by viewModel.uiState.collectAsState()
    LaunchedEffect(refreshKey) {
        viewModel.refresh()
    }
    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = Color(0xFF8B6D4B),
                    titleContentColor = Color(0xFF212529),
                ),
                navigationIcon = {
                    IconButton(onClick = {
                        viewModel.refresh()
                        Timber.d("Ca viens de refresh")
                    }) {
                        Icon(
                            Icons.Filled.Refresh,
                            contentDescription = "refresh button"
                        )
                    }
                },
                title = {
                    Text("Profile Screen")
                }
            )
        },
        bottomBar = {
            AppBottomBar(navController = navController)
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            when (state) { // en fonction de state on va gérer l'Ui et on affichera la data que si MyUiState est success
                is MyUiState.Loading -> CircularProgressIndicator()
                is MyUiState.Error -> Text("Error: ${(state as MyUiState.Error).error?.message}")
                is MyUiState.Success -> OrderList(
                    orders = (state as MyUiState.Success<List<Order>>).data ?: emptyList()
                )
                is MyUiState.Empty -> Text("No news available")
                is MyUiState.Idle -> Unit
            }
//            OrderList(orders = orderList)
        }
    }
}

//suspend fun fetchOrder(): List<Order>? {
//
//    try {
//        val strapiApiKey = BuildConfig.apiKey
//        val response = DwitchServiceFactory.dwitchService.getOrders("Bearer $strapiApiKey")
//        val orderList = response.data
//        return orderList
//    } catch (e: Exception) {
//        Timber.d("Error fetching orders: ${e.message}")
//        return null
//    }
//}