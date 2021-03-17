package com.example.unsplash

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.unsplash.adapter.Adapter
import com.unsplash.pickerandroid.photopicker.UnsplashPhotoPicker

class MainActivity : AppCompatActivity() {

    private lateinit var myAdapter: Adapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView()

        myAdapter = Adapter(this)

    }


    fun setupRecyclerView(){
        val myRecyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        myRecyclerView.layoutManager = LinearLayoutManager(this)
        myRecyclerView.adapter = this.myAdapter





    }



}
