package com.example.dwitchapp.data.model

import com.squareup.moshi.JsonClass
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Locale


@JsonClass(generateAdapter = true)
data class Order (
        val id: Long? = null,
        val documentId: String? = null,
        val placedAt: String? = null,
        val receivedAt: String? = null,
        val cookMessage: String? = null,
        val price: Long? = null,
        val progress: Long? = null,
        val createdAt: String? = null,
        val updatedAt: String? = null,
        val publishedAt: String? = null,
        val ingredients: List<Ingredient>? = null,
        val users_permissions_user: UsersPermissionsUser? = null,
        val store: Store? = null
)
        {
        fun getFormatedPlacedAtDate(): String {
                val instant = Instant.parse(placedAt)
                val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy à HH:mm", Locale.FRANCE)
                val dateTime = instant.atZone(ZoneId.of("Europe/Paris")).toLocalDateTime()
                return dateTime.format(formatter)
        }
}
