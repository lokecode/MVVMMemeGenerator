package com.example.httpmethodsretrofitexample.feature_meme_generator.di

import com.example.httpmethodsretrofitexample.feature_meme_generator.data.remote.MemeApis
import com.example.httpmethodsretrofitexample.feature_meme_generator.data.remote.MemeApis.Companion.BASE_URL
import com.example.httpmethodsretrofitexample.feature_meme_generator.data.repository.MemeApisRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CallApis {

    private val apiInstance by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MemeApis::class.java)
    }

    fun refreshMemes(){
        MemeApisRepository(apiInstance).get()
    }
    fun postMeme() {
        MemeApisRepository(apiInstance).post()
    }

    fun deleteMeme(id: String){
        MemeApisRepository(apiInstance).delete(id)
    }
    fun updateMeme(id: String){
        MemeApisRepository(apiInstance).update(id)
    }
}


