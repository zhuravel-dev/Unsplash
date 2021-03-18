package com.example.unsplash.adapter

import android.graphics.BitmapFactory
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.unsplash.DetailsClickListener
import com.example.unsplash.MyViewModel
import com.example.unsplash.R
import com.example.unsplash.models.Results
import com.google.gson.internal.bind.TypeAdapters.URL
import kotlinx.android.synthetic.main.item_photo.view.*
import java.net.MalformedURLException
import java.net.URL
import java.util.concurrent.Executors

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val executor = Executors.newSingleThreadExecutor()
    private val uiHandler = Handler(Looper.getMainLooper())

    fun bind(result: Results, clickListener: DetailsClickListener?){

        val imageView = itemView.findViewById<ImageView>(R.id.image)

        setImage(result.description, imageView)
    }

    private fun setImage(link: String, imageView: ImageView){
        try{
            val url = URL(link)
            executor.submit{
                val bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream())
                uiHandler.post { imageView.setImageBitmap(bmp)}
            }.get()
        } catch (ex: MalformedURLException) {
            Log.e(ViewHolder::class.java.simpleName, ex.localizedMessage.orEmpty())
        }
    }

}