package com.example.rxjavaretrofitpost.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rxjavaretrofitpost.model.datasource.postresponse.Post
import com.example.rxjavaretrofitpost.model.datasource.remote.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel: ViewModel() {
    private val responseData = MutableLiveData<String>()
    private val TAG_POST = "TAG_POST"

    fun sendPost(title: String, body: String) {
        RetrofitClient.getClient().savePost(title, body, 1).enqueue(object : Callback<Post> {
            override fun onFailure(call: Call<Post>, t: Throwable) {
                Log.e(TAG_POST, "Unable to submit post to API.")
            }

            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                if(response.isSuccessful) {
                    responseData.value = response.body().toString()
                    Log.i(TAG_POST, "post submitted to API." + response.body().toString())
                }
            }
        })
    }

    fun getResponseData(): LiveData<String> = responseData
}