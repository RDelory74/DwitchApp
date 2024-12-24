package com.example.dwitchapp.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.DrawerDefaults.shape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import coil3.compose.AsyncImagePainter
import com.example.dwitchapp.data.model.color
import com.example.dwitchapp.data.model.emoji
import com.example.dwitchapp.data.model.news.News
import timber.log.Timber

@Composable
fun NewsList(articles: List<News>) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        items(articles) { article ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White, shape = RoundedCornerShape(16.dp))
                    .padding(8.dp)
                    .shadow(20.dp, shape = RoundedCornerShape(16.dp))
            ) {
                Column {
                    ListItem(
                        headlineContent = {
                            Text(
                                "${article.title}",
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                                modifier = Modifier.padding(6.dp)
                            )
                        },
                        overlineContent = {
                            article.medias?.firstOrNull()?.let { media ->
                                AsyncImage(
                                    model = "https://dwitch.pickle-forge.app${media.url}",
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .height(160.dp)
                                        .fillMaxSize()
                                        .shadow(5.dp, shape = RoundedCornerShape(8.dp))
                                )
                            }
                        },
                        supportingContent = {
                            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                                Text(
                                    "Publié le ${article.createdAt}",
                                    fontWeight = FontWeight.Medium,
                                    fontStyle = FontStyle.Italic
                                )
//                            Text("MAJ le ${article.updatedAt}")
                                Text("${article.content}")
                            }
                        }
                    )
                }
            }
        }
    }
}
