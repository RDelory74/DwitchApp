package com.example.dwitchapp.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.dwitchapp.navigation.NewsScreenRoute
import com.example.dwitchapp.navigation.OrderingScreenRoute
import com.example.dwitchapp.navigation.ProfileScreenRoute
import com.example.dwitchapp.ui.screens.NewsScreen
import com.example.dwitchapp.ui.screens.ProfileScreen
import com.example.dwitchapp.ui.theme.DwitchAppTheme
import timber.log.Timber

@Composable
fun GlobalLayout() {
    var refreshKey by remember {
        mutableStateOf(0)
    }
    val navController = rememberNavController()
    DwitchAppTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF3FFCF))
        ) {
            NavHost(navController = navController, startDestination = ProfileScreenRoute) {
                composable<ProfileScreenRoute> {
                    ProfileScreen(refreshKey, navController)
                }
                composable<NewsScreenRoute> {
                    NewsScreen(refreshKey, navController)
                }
                composable<OrderingScreenRoute> {
                    Text("Ordering Screen", color = Color.White)
                }
            }
        }
    }
}