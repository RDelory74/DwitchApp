package com.example.dwitchapp.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.dwitchapp.data.model.Order
import com.example.dwitchapp.data.model.color
import com.example.dwitchapp.data.model.emoji

@Composable
fun OrderList(orders: List<Order>) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        items(orders) { order ->
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
                                "Mess: ${order.cookMessage}",
                                modifier = Modifier.padding(6.dp)
                            )
                        },
                        overlineContent = {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                            ) {
                                Icon(
                                    Icons.Filled.ShoppingCart,
                                    contentDescription = "Localized description",
                                )

                                Text("Le ${order.placedAt}")
                                Surface(
                                    shape = MaterialTheme.shapes.small
                                ){
                                Text(
                                    "${order.price} €",
                                    modifier = Modifier
                                        .background(Color(0xFFFFD1D1))
                                        .padding(5.dp)
                                )
                                }
                            }
                        },
                        supportingContent = {
                            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                                LazyRow(
                                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    items(order.ingredients ?: emptyList()) { ingredient ->
                                        Row(
                                            modifier = Modifier
                                                .background(ingredient.kind.color())
                                                .padding(6.dp),
                                            horizontalArrangement = Arrangement.spacedBy(4.dp)
                                        ) {
                                            Text("${ingredient.kind.emoji()}")
                                            Text("${ingredient.name}", fontWeight = FontWeight.Bold)
                                        }
                                    }
                                }
                                HorizontalDivider()
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(8.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text("Progress")
                                    val currentProgress = (order.progress ?: 0L).toFloat() / 100f
                                    LinearProgressIndicator(
                                        progress = { currentProgress },

                                        )
                                    Text("${order.progress}%")
                                }
                                HorizontalDivider()
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                ) {
                                    Text("\uD83C\uDFE4\u200B")
                                    Text("${order.store?.name}")
                                    Text("- ${order.store?.city}")
                                    Text(" ${order.store?.zipCode}")
                                }
                            }
                        }
                    )
                }
            }
        }
    }
}