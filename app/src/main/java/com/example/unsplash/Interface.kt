package com.example.unsplash

import com.example.unsplash.models.Json4Kotlin_Base
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Interface {
    @GET("/search/photos")
    fun getContent(
        @Query("query") query: String = "random",
        @Query("client_id") clientId: String = "qv1dofP-Sn7hvmZTx3UDqzFk2YrM_rfOynokvMbeiMs"
    ): Call<Json4Kotlin_Base>
}