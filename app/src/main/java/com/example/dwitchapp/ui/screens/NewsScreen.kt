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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.dwitchapp.BuildConfig
import com.example.dwitchapp.data.model.news.News
import com.example.dwitchapp.service.DwitchServiceFactory
import com.example.dwitchapp.ui.component.AppBottomBar
import com.example.dwitchapp.ui.component.NewsList
import com.example.dwitchapp.viewmodel.MyUiState
import com.example.dwitchapp.viewmodel.NewsViewModel
import kotlinx.coroutines.launch
import timber.log.Timber

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsScreen(refreshKey: Int, navController: NavController) {
    val viewModel: NewsViewModel = viewModel()
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
                        Timber.d("Tu viens de refresh ")
                    }) {
                        Icon(
                            Icons.Filled.Refresh,
                            contentDescription = "refresh button"
                        )
                    }
                },
                title = {
                    Text("News Screen")
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
                is MyUiState.Success -> NewsList(
                    articles = (state as MyUiState.Success<List<News>>).data ?: emptyList()
                )

                is MyUiState.Empty -> Text("No news available")
                is MyUiState.Idle -> Unit
//            NewsList(articles = news) // NewsList = loadNews() (nom demandé par l'énoncé)
            }
        }
    }
}

//    val scope = rememberCoroutineScope()
//    var newsList by remember { mutableStateOf(emptyList<News>()) }
//
//    suspend fun fetchNews(): List<News>? {
//        try {
//            val strapiApiKey = BuildConfig.apiKey
//            val response = DwitchServiceFactory.dwitchService.getNews("Bearer $strapiApiKey")
//            val newsList = response.data
//            return newsList
//        } catch (e: Exception) {
//            // handle error - at the moment we just print
//            Timber.d("Error fetching orders: ${e.message}")
//            return null
//        }
//    }
