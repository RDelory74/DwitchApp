package com.example.dwitchapp.service


import com.example.dwitchapp.data.dto.NewsResponse
import com.example.dwitchapp.data.dto.OrdersResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import java.util.Date
import retrofit2.http.Header


interface DwitchService {
    @GET("orders?populate=*")
    suspend fun getOrders(
        @Header("Authorization") token: String
    ): OrdersResponse
    @GET("posts?populate=*")
    suspend fun getNews(
        @Header("Authorization") token: String
    ): NewsResponse
}

object DwitchServiceFactory {
    val moshi = Moshi.Builder()
        .add(Date::class.java, Rfc3339DateJsonAdapter().nullSafe())
        .build()
        var retrofit = Retrofit.Builder()
            .baseUrl("https://dwitch.pickle-forge.app/api/")
//            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
// Puis créez votre service
        val dwitchService: DwitchService = retrofit.create(DwitchService::class.java)

    }

//gestion des header de requete dans DwitchServiceFactory
//    val okHttpClient = OkHttpClient.Builder()
//        .addInterceptor { chain ->
//            val originalRequest = chain.request()
//            val authenticatedRequest = originalRequest.newBuilder()
//                .addHeader(
//                    "Authorization",
//                    "Bearer 49b70f996ffbb654be996f8604d118bfca7624ced27749df6f4fdcac30b7009da1ba63ef7d6b91c8ca814baf88955daba2804396ab3b8cd2c03b50a1f96ff330032d2fbc2238338b4f7e25bff9e852b002c26ecca02fbf1e8e261cf6e0cdb00c042e35b33f64dda3522c3178ba1edb22b9daba42b51c1c8355309fd475b5d92b"
//                )
//                .build()
//            chain.proceed(authenticatedRequest)
//        }
//        .build()

//pour moshi
//        .add(KotlinJsonAdapterFactory())
//        .add(IngredientKindAdapter())
//    class IngredientKindAdapter {
//        @ToJson
//        fun toJson(kind: IngredientKind): String = kind.name.lowercase()
//
//        @FromJson
//        fun fromJson(value: String): IngredientKind =
//            IngredientKind.valueOf(value.uppercase())
//    }