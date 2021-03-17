package com.example.unsplash.models

import com.google.gson.annotations.SerializedName


data class Json4Kotlin_Base (

	@SerializedName("total") val total : Int,
	@SerializedName("total_pages") val total_pages : Int,
	@SerializedName("results") val results : List<Results>
)