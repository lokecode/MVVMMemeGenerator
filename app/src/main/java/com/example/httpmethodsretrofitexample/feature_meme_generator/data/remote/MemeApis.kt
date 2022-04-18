package com.example.httpmethodsretrofitexample.feature_meme_generator.data.remote

import com.example.httpmethodsretrofitexample.feature_meme_generator.domain.model.MemeModel
import com.example.httpmethodsretrofitexample.feature_meme_generator.domain.model.PostMemeModel
import okhttp3.Response
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*


interface MemeApis {
    @GET("user")
    suspend fun getMemes(): List<MemeModel>

    @DELETE("user/{id}")
    suspend fun deleteMeme(@Path("id") id: String): Unit


    @PUT("/user/{id}")
    suspend fun updateMeme(@Path("id") id: String, @Body requestBody: PostMemeModel): Call<PostMemeModel>

    @POST("/user")
    suspend fun postMeme(@Body requestBody: PostMemeModel): Call<ResponseBody>

    companion object {
        const val BASE_URL = "https://us-central1-rest-api-ed3bc.cloudfunctions.net"
    }
}