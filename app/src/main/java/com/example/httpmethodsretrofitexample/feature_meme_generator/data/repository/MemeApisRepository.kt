package com.example.httpmethodsretrofitexample.feature_meme_generator.data.repository

import com.example.httpmethodsretrofitexample.feature_meme_generator.data.local.Constants
import com.example.httpmethodsretrofitexample.feature_meme_generator.data.local.Constants.Companion.arrayOfMemeImg
import com.example.httpmethodsretrofitexample.feature_meme_generator.data.local.Constants.Companion.arrayOfMemeText
import com.example.httpmethodsretrofitexample.feature_meme_generator.data.local.Constants.Companion.myAdapter
import com.example.httpmethodsretrofitexample.feature_meme_generator.data.local.Constants.Companion.randomImg
import com.example.httpmethodsretrofitexample.feature_meme_generator.data.local.Constants.Companion.randomText
import com.example.httpmethodsretrofitexample.feature_meme_generator.data.remote.MemeApis
import com.example.httpmethodsretrofitexample.feature_meme_generator.domain.model.MemeModel
import com.example.httpmethodsretrofitexample.feature_meme_generator.domain.model.PostMemeModel
import kotlinx.coroutines.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MemeApisRepository(
    Api: MemeApis
) {
    val api = Api
    val myMeme = PostMemeModel(arrayOfMemeImg[randomImg], arrayOfMemeText[randomText])

    fun get() {
        CoroutineScope(Dispatchers.IO).launch {
            val retrofitData = api.getPost()
            retrofitData.enqueue(object : Callback<List<MemeModel>?> {
                override fun onResponse(call: Call<List<MemeModel>?>, response: Response<List<MemeModel>?>) {
                    response.body()?.let { myAdapter.setData(it) }
                }
                override fun onFailure(call: Call<List<MemeModel>?>, t: Throwable) {
                    Constants
                }
            })
        }
    }

    fun delete(id: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val requestCall = api.deletePost(id)
            requestCall.enqueue(object: Callback<Unit> {
                override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                    get()
                }
                override fun onFailure(call: Call<Unit>, t: Throwable) {
                    Constants
                }
            })
        }
    }

    fun update(id: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = api.updateMeme(id, myMeme)
            response.enqueue(object: Callback<PostMemeModel> {
                override fun onResponse(call: Call<PostMemeModel>, response: Response<PostMemeModel>) {
                    get()
                }
                override fun onFailure(call: Call<PostMemeModel>, t: Throwable) {
                    get()
                }
            })
        }
    }

    fun post() {
        CoroutineScope(Dispatchers.IO).launch {
            val postRequest = api.createEmployee(myMeme)
            postRequest.enqueue(object: Callback<ResponseBody> {
                override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                    get()
                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    Constants
                }

            })
        }
    }
}