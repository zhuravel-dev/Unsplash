package com.example.unsplash

import com.example.unsplash.models.Json4Kotlin_Base
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Interface {
    @GET("top.json")
    fun getContent(
        @Query("limit") limit: Int = 30,
        @Query("after") after: String? = null
    ): Call<Json4Kotlin_Base>
}