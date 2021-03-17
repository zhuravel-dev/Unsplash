package com.example.unsplash.models

import com.google.gson.annotations.SerializedName


data class Results (

	@SerializedName("id") val id : String,
	@SerializedName("created_at") val created_at : String,
	@SerializedName("updated_at") val updated_at : String,
	@SerializedName("promoted_at") val promoted_at : String,
	@SerializedName("width") val width : Int,
	@SerializedName("height") val height : Int,
	@SerializedName("color") val color : String,
	@SerializedName("blur_hash") val blur_hash : String,
	@SerializedName("description") val description : String,
	@SerializedName("alt_description") val alt_description : String,
	@SerializedName("urls") val urls : Urls,
	@SerializedName("links") val links : Links,
	@SerializedName("categories") val categories : List<String>,
	@SerializedName("likes") val likes : Int,
	@SerializedName("liked_by_user") val liked_by_user : Boolean,
	@SerializedName("current_user_collections") val current_user_collections : List<String>,
	@SerializedName("sponsorship") val sponsorship : String,
	@SerializedName("user") val user : User,
	@SerializedName("tags") val tags : List<Tags>
)