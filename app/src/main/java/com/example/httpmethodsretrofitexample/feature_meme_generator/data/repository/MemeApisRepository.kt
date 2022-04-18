package com.example.httpmethodsretrofitexample.feature_meme_generator.data.repository

import android.util.Log
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
import java.io.IOException


class MemeApisRepository(
    Api: MemeApis
) {
    val api = Api
    val myMeme = PostMemeModel(arrayOfMemeImg[randomImg], arrayOfMemeText[randomText])

    fun get() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                withContext(Dispatchers.Main){
                    api.getMemes().let { myAdapter.setData(it) }
                }
            } catch (e: IOException) {
                Log.d("MainActivity", "${e}")
            }
        }
    }

    fun delete(id: String) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                api.deleteMeme(id)
                get()
            } catch (e: IOException) {
                Log.d("MainActivity", "${e}")
            }
        }
    }

    fun update(id: String) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                api.updateMeme(id, myMeme)
                get()
            } catch (e: IOException) {
                Log.d("MainActivity", "${e}")
            }
        }
    }

    fun post() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                api.postMeme(myMeme)
                get()
            } catch (e: IOException) {
                Log.d("MainActivity", "${e}")
            }

        }
    }
}