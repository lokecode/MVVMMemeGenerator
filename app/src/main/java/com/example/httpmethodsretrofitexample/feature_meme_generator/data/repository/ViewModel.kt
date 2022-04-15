package com.example.httpmethodsretrofitexample.feature_meme_generator.data.repository

import com.example.httpmethodsretrofitexample.feature_meme_generator.data.local.Constants
import com.example.httpmethodsretrofitexample.feature_meme_generator.data.local.Constants.Companion.arrayOfMemeImg
import com.example.httpmethodsretrofitexample.feature_meme_generator.data.local.Constants.Companion.arrayOfMemeText
import com.example.httpmethodsretrofitexample.feature_meme_generator.data.local.Constants.Companion.myAdapter
import com.example.httpmethodsretrofitexample.feature_meme_generator.data.local.Constants.Companion.randomImg
import com.example.httpmethodsretrofitexample.feature_meme_generator.data.local.Constants.Companion.randomText
import com.example.httpmethodsretrofitexample.feature_meme_generator.di.RetrofitInstance
import com.example.httpmethodsretrofitexample.feature_meme_generator.domain.model.Data_Type
import com.example.httpmethodsretrofitexample.feature_meme_generator.domain.model.model
import kotlinx.coroutines.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ViewModel() {

    fun getMyData() {
        val retrofitBuilder = RetrofitInstance.retrofit

        CoroutineScope(Dispatchers.IO).launch {
            val retrofitData = retrofitBuilder.getPost()
            retrofitData.enqueue(object : Callback<List<Data_Type>?> {
                override fun onResponse(call: Call<List<Data_Type>?>, response: Response<List<Data_Type>?>) {
                    response.body()?.let { myAdapter.setData(it) }
                }
                override fun onFailure(call: Call<List<Data_Type>?>, t: Throwable) {
                    Constants
                }
            })
        }
    }

    fun deleteMeme(id: String) {
        val retrofitBuilder = RetrofitInstance.retrofit
        CoroutineScope(Dispatchers.IO).launch {
            val requestCall = retrofitBuilder.deletePost(id)
            requestCall.enqueue(object: Callback<Unit> {
                override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                    getMyData()
                }
                override fun onFailure(call: Call<Unit>, t: Throwable) {
                    Constants
                }
            })
        }
    }

    fun updateMeme(id: String) {
        val retrofitBuilder = RetrofitInstance.retrofit
        val myMeme = model(Constants.arrayOfMemeImg[randomImg], Constants.arrayOfMemeText[randomText])
        CoroutineScope(Dispatchers.IO).launch {
            val response = retrofitBuilder.updateMeme(id, myMeme)
            response.enqueue(object: Callback<model> {
                override fun onResponse(call: Call<model>, response: Response<model>) {
                    getMyData()
                }
                override fun onFailure(call: Call<model>, t: Throwable) {
                    getMyData()
                }
            })
        }
    }

    fun postMeme() {
        val retrofitBuilder = RetrofitInstance.retrofit
        val myMeme = model(arrayOfMemeImg[randomImg], arrayOfMemeText[randomText])

        val postRequest = retrofitBuilder.createEmployee(myMeme)
        postRequest.enqueue(object: Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                getMyData()
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Constants
            }

        })
    }
}