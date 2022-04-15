package com.example.httpmethodsretrofitexample.feature_meme_generator.di

import com.example.httpmethodsretrofitexample.feature_meme_generator.data.remote.APIService
import com.example.httpmethodsretrofitexample.feature_meme_generator.data.remote.APIService.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object  RetrofitInstance {

    val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APIService::class.java)
    }
}


