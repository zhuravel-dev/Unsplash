package com.example.unsplash.models

import com.google.gson.annotations.SerializedName


data class Type (

	@SerializedName("slug") val slug : String,
	@SerializedName("pretty_slug") val pretty_slug : String
)