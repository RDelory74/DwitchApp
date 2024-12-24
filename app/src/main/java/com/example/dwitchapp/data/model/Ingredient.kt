package com.example.dwitchapp.data.model


import com.example.dwitchapp.ui.theme.OpenColors
import com.example.dwitchapp.ui.theme.OpenColorsPalette
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Ingredient(
    val id: Long? = null,
    val documentID: String? = null,
    val name: String? = null,
    val description: String? = null,
    val isVegan: Boolean? = null,
    val isSpicy: Boolean? = null,
    val kind: IngredientKind,
    val createdAt: String? = null,
    val updatedAt: String? = null,
    val publishedAt: String? = null,
)


enum class IngredientKind {
    @Json(name = "topping") TOPPING,
    @Json(name = "sauce") SAUCE,
    @Json(name = "main") MAIN,
    @Json(name = "bread") BREAD,
    @Json(name = "inconnu") UNKNOW,
}


fun IngredientKind.color() = when (this) {

    IngredientKind.MAIN -> OpenColors.getColorScale(OpenColorsPalette.Red)[1]
    IngredientKind.SAUCE -> OpenColors.getColorScale(OpenColorsPalette.Yellow)[1]
    IngredientKind.TOPPING -> OpenColors.getColorScale(OpenColorsPalette.Indigo)[1]
    IngredientKind.BREAD -> OpenColors.getColorScale(OpenColorsPalette.Orange)[8]
    IngredientKind.UNKNOW-> OpenColors.getColorScale(OpenColorsPalette.Orange)[8]

}

fun IngredientKind.emoji() = when (this) {
    IngredientKind.MAIN -> "\u200B\uD83E\uDD69"
    IngredientKind.SAUCE -> "\uD83C\uDF6F"
    IngredientKind.TOPPING -> "\uD83E\uDDC5\u200B"
    IngredientKind.BREAD -> "\uD83E\uDD6F\u200B"
    IngredientKind.UNKNOW -> "❓\u200B"
}

