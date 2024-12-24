package com.example.dwitchapp.service

import com.example.dwitchapp.data.model.Order
import com.example.dwitchapp.data.model.Ingredient
import com.example.dwitchapp.data.model.IngredientKind
import com.example.dwitchapp.data.model.Store
import com.example.dwitchapp.data.model.UsersPermissionsUser

val mockOrders = listOf(
    Order(
        id = 1L,
        documentId = "DOC12345",
        placedAt = "2024-12-10T10:00:00",
        receivedAt = "2024-12-10T12:00:00",
        cookMessage = "Order is being prepared",
        price = 25,
        progress = 75L,
        createdAt = "2024-12-09T08:00:00",
        updatedAt = "2024-12-10T09:30:00",
        publishedAt = "2024-12-09T08:05:00",
        ingredients = listOf(
            Ingredient(
                name= "Pain Complet",
                isVegan = false,
                isSpicy = false,
                kind = IngredientKind.BREAD
            ),
            Ingredient(
                name= "Tomate",
                isVegan = true,
                isSpicy = false,
                kind = IngredientKind.UNKNOW
            ),
            Ingredient(
                name= "Oignons",
                isVegan = true,
                isSpicy = false,
                kind = IngredientKind.TOPPING
            ),
            Ingredient(
                name= "Salade",
                isVegan = true,
                isSpicy = false,
                kind = IngredientKind.MAIN
            )
        ),
        users_permissions_user = UsersPermissionsUser(id = 123L, username = "johndoe"),
        store = Store(
            id = 1L,
            name = "PizzaPlace",
            city = "Epagny",
            zipCode = "74330"
        )
    ),
    Order(
        id = 2L,
        documentId = "DOC12346",
        placedAt = "2024-12-11T11:15:00",
        receivedAt = "2024-12-11T13:00:00",
        cookMessage = "Order is ready for pickup",
        price = 45,
        progress = 100L,
        createdAt = "2024-12-10T09:00:00",
        updatedAt = "2024-12-11T10:50:00",
        publishedAt = "2024-12-10T09:05:00",
        ingredients = listOf(
            Ingredient(
                name= "Pain Ciabatta",
                isVegan = false,
                isSpicy = false,
                kind = IngredientKind.BREAD
            ),
            Ingredient(
                name= "Jambon",
                isVegan = false,
                isSpicy = false,
                kind = IngredientKind.MAIN
            ),
            Ingredient(
                name= "Mayonnaise",
                isVegan = false,
                isSpicy = false,
                kind = IngredientKind.SAUCE
            ),
            Ingredient(
                name= "Cornichons",
                isVegan = true,
                isSpicy = false,
                kind = IngredientKind.TOPPING
            )
        ),
        users_permissions_user = UsersPermissionsUser(id = 456L, username = "janedoe"),
        store = Store(id = 2L,
            name = "BurgerKing",
            city = "Seynod",
            zipCode = "74600")
    ),
    Order(
        id = 3L,
        documentId = "DOC12347",
        placedAt = "2024-12-12T14:30:00",
        receivedAt = null,
        cookMessage = "In progress",
        price = 18,
        progress = 50L,
        createdAt = "2024-12-11T10:00:00",
        updatedAt = "2024-12-12T13:00:00",
        publishedAt = "2024-12-11T10:10:00",
        ingredients = listOf(
            Ingredient(
                name= "Pain Baguette",
                isVegan = false,
                isSpicy = false,
                kind = IngredientKind.BREAD
            ),
            Ingredient(
                name= "Mozzarella",
                isVegan = false,
                isSpicy = false,
                kind = IngredientKind.UNKNOW
            ),
            Ingredient(
                name= "Parma",
                isVegan = false,
                isSpicy = false,
                kind = IngredientKind.MAIN
            ),
            Ingredient(
                name= "Roquette",
                isVegan = true,
                isSpicy = false,
                kind = IngredientKind.UNKNOW
            )
        ),
        users_permissions_user = UsersPermissionsUser(id = 789L, username = "samsmith"),
        store = Store(
            id = 3L,
            name = "SushiBar",
            city = "Annecy",
            zipCode = "74000"

        )
    ),
    Order(
        id = 4L,
        documentId = "DOC12347",
        placedAt = "2024-12-16T13:30:00",
        receivedAt = null,
        cookMessage = "In progress",
        price = 18,
        progress = 50L,
        createdAt = "2024-12-11T10:00:00",
        updatedAt = "2024-12-12T13:00:00",
        publishedAt = "2024-12-11T10:10:00",
        ingredients = listOf(
            Ingredient(
                name= "Pain Baguette",
                isVegan = false,
                isSpicy = false,
                kind = IngredientKind.BREAD
            ),
            Ingredient(
                name= "Mozzarella",
                isVegan = false,
                isSpicy = false,
                kind = IngredientKind.UNKNOW
            ),
            Ingredient(
                name= "Parma",
                isVegan = false,
                isSpicy = false,
                kind = IngredientKind.MAIN
            ),
            Ingredient(
                name= "Roquette",
                isVegan = true,
                isSpicy = false,
                kind = IngredientKind.UNKNOW
            ),
            Ingredient(
                name= "Tomate",
                isVegan = true,
                isSpicy = false,
                kind = IngredientKind.UNKNOW
            )
        ),
        users_permissions_user = UsersPermissionsUser(id = 789L, username = "samsmith"),
        store = Store(
            id = 3L,
            name = "L'étagère",
            city = "Annecy",
            zipCode = "74000"

        )
    )
)