package com.example.unsplash

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.unsplash.pickerandroid.photopicker.UnsplashPhotoPicker

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
}