package com.example.unsplash

import android.annotation.SuppressLint
import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.unsplash.adapter.Adapter
import com.example.unsplash.models.Results
import kotlinx.android.synthetic.main.activity_main.*
import com.unsplash.pickerandroid.photopicker.UnsplashPhotoPicker
import androidx.core.view.isVisible as isVisible1


class MainActivity : AppCompatActivity(), DetailsClickListener{


       val adapter by lazy {
           Adapter().apply {
               myclickLictener = this@MainActivity
           }
       }

    private var progressBar: ProgressBar? = null
    private var viewModel: MyViewModel? = null
    private var after: String? = null
    private var lastFetchedPosition: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecyclerView()
        progressBar = findViewById(R.id.progress_bar)
        viewModel = ViewModelProvider(this).get(MyViewModel::class.java)

        observeLiveData()

        viewModel?.getAllData(DEFAULT_ITEMS_COUNT)

         }


    fun observeLiveData(){
        viewModel?.showProgress?.observe(this) { show ->
            progressBar?.isVisible1 = show
        }
        viewModel?.setData?.observe(this) { data ->
            adapter.setData(data)
        }
        viewModel?.after?.observe(this) {t -> this@MainActivity.after}

    }



    fun setupRecyclerView(){
        val myRecyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        myRecyclerView.layoutManager = LinearLayoutManager(this)
        myRecyclerView.adapter = this.adapter

        myRecyclerView.addOnScrollListener(object: RecyclerView.OnScrollListener() {
            override fun OnScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val manager = recyclerView.layoutManager as? LinearLayoutManager
                val lastPosition = manager?.findLastCompletelyVisibleItemPosition()?:0
                val lastPlusOne = lastPosition + 1
                if (lastPlusOne%DEFAULT_ITEMS_COUNT == 0 && lastPlusOne > lastFetchedPosition) {
                    viewModel?.getAllData(DEFAULT_ITEMS_COUNT, after)
                    lastFetchedPosition = lastPlusOne
                }
            }
        })

    }

    override fun onClick(results: Results) {

    }

    companion object {
        const val DEFAULT_ITEMS_COUNT = 30
    }

}
