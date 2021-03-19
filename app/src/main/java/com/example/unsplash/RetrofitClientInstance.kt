package com.example.unsplash

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClientInstance {

    val baseUrl = "https://unsplash.com/s/photos/random-photo/"

    fun getRetrofit () = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

