package com.example.unsplash.models

import com.google.gson.annotations.SerializedName


data class Tags (

	@SerializedName("type") val type : String,
	@SerializedName("title") val title : String,
	@SerializedName("source") val source : Source
)