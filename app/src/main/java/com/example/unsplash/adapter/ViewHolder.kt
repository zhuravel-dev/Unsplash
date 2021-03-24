package com.example.unsplash.adapter

import android.content.res.Resources
import android.graphics.BitmapFactory
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.unsplash.DetailsClickListener
import com.example.unsplash.R
import com.example.unsplash.models.Results
import java.net.MalformedURLException
import java.net.URL
import java.util.concurrent.Executors

class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    private val executor = Executors.newSingleThreadExecutor()
    private val uiHandler = Handler(Looper.getMainLooper())
    private val imageView: ImageView by lazy {
        itemView.findViewById(R.id.image)
    }

    init {
        val displayMetrics = Resources.getSystem().displayMetrics
        val displayWidthPx = displayMetrics.widthPixels
        imageView.layoutParams = imageView.layoutParams.apply {
            width = displayWidthPx
            height = displayWidthPx
        }
    }

    fun bind(result: Results, clickListener: DetailsClickListener?) {
        setImage(result.urls.thumb, imageView)
        itemView.setOnClickListener {
            clickListener?.onClick(result)
        }
    }


    private fun setImage(link: String, imageView: ImageView) {
        try {
            val url = URL(link)
            executor.submit{
                val bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream())
                uiHandler.post { imageView.setImageBitmap(bmp) }
            }.get()
        } catch (ex: MalformedURLException) {
            Log.e(ViewHolder::class.java.simpleName, ex.localizedMessage.orEmpty())
        }
    }

}