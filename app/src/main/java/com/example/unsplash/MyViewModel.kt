package com.example.unsplash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.unsplash.models.Json4Kotlin_Base
import com.example.unsplash.models.Results
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyViewModel: ViewModel() {

    private val _showProgress = MutableLiveData<Boolean>()
    val showProgress: LiveData<Boolean> = _showProgress


    private val _setData = MutableLiveData<List<Results>>()
    val setData: LiveData<List<Results>> = _setData

    private val _after = MutableLiveData<String>()
    val after: LiveData<String> = _after

    fun getAllData(count: Int, after: String? = null) {
        _showProgress.postValue(true)
        val service = RetrofitClientInstance.getRetrofit().create(Interface::class.java)
        val call: Call<Json4Kotlin_Base> = service.getContent()
        call.enqueue(object : Callback<Json4Kotlin_Base> {
            override fun onResponse(
                call: Call<Json4Kotlin_Base>,
                response: Response<Json4Kotlin_Base>
            ) {
                if (response.isSuccessful) {
                    val body: Json4Kotlin_Base? = response.body()
                    if (body != null) {
                        val children = body.results
                        _setData.postValue(children)
                    }
                }
                _showProgress.postValue(false)
            }

            override fun onFailure(call: Call<Json4Kotlin_Base>, t: Throwable) {
                _showProgress.postValue(false)
            }
        })
    }
}

