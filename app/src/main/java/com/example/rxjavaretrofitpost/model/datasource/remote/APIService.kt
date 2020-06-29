package com.example.rxjavaretrofitpost.model.datasource.remote

import com.example.rxjavaretrofitpost.model.datasource.postresponse.Post
import com.example.rxjavaretrofitpost.model.datasource.remote.APIConstants.Companion.API_PATH
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface APIService {
    @POST(API_PATH)
    @FormUrlEncoded
    fun savePost(
        @Field("title") title: String,
        @Field("body") body: String,
        @Field("userId") userId: Long
    ): Call<Post>
}