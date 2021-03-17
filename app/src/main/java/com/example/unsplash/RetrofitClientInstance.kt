package com.example.unsplash

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClientInstance {

    val baseUrl = "https://api.unsplash.com/search/photos"

    fun getRetrofit () = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}
