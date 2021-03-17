package com.example.unsplash.adapter

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_photo.view.*

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val imageView: ImageView = view.image
}