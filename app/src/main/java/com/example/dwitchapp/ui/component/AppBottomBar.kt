package com.example.dwitchapp.ui.component

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.dwitchapp.navigation.Screen

@Composable
fun AppBottomBar(
    navController: NavController
//    currentScreen: Screen,

) {
    BottomAppBar(
        containerColor = Color(0xFF8B6D4B),
        contentColor = MaterialTheme.colorScheme.onSurfaceVariant,
    ) {
        val currentBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = currentBackStackEntry?.destination?.route
        Screen.getAllScreens().forEach { screen ->
            val isSelected = currentDestination == screen.route::class.qualifiedName.orEmpty()
            NavigationBarItem(
                icon = { Icon(screen.icon, contentDescription = screen.label) },
                label = { Text(screen.label) },
                selected = isSelected,
                onClick = {
                    navController.navigate(screen.route) {
                        navController
                            .graph
                            .startDestinationRoute
                            ?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}