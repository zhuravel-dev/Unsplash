package com.example.unsplash.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.unsplash.R
import com.example.unsplash.models.Results
import com.unsplash.pickerandroid.photopicker.data.UnsplashPhoto


class Adapter constructor(context: Context): RecyclerView.Adapter<ViewHolder>() {

    private var mListOfPhotos : MutableList<Results>  = mutableListOf()



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_photo, parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }


    override fun getItemCount(): Int = mListOfPhotos.size

}