package com.example.dwitchapp.navigation


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.serialization.Serializable

@Serializable data object ProfileScreenRoute

@Serializable data object NewsScreenRoute

@Serializable data object OrderingScreenRoute



sealed class Screen(val route: Any, val icon: ImageVector, val label: String) {
    data object Profile : Screen(ProfileScreenRoute, Icons.Default.Person, "Profile")
    data object News : Screen(NewsScreenRoute, Icons.Default.Star, "News")
    data object Ordering : Screen(OrderingScreenRoute, Icons.Default.ShoppingCart, "Commandes")

    companion object {
        fun getAllScreens() = listOf(Profile, News, Ordering)
    }
}