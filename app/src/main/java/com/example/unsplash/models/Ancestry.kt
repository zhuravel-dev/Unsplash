package com.example.unsplash.models

import com.google.gson.annotations.SerializedName


data class Ancestry (

	@SerializedName("type") val type : Type,
	@SerializedName("category") val category : Category,
	@SerializedName("subcategory") val subcategory : Subcategory
)