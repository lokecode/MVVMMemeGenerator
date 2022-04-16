package com.example.httpmethodsretrofitexample.feature_meme_generator.data.remote

import com.example.httpmethodsretrofitexample.feature_meme_generator.domain.model.MemeModel
import com.example.httpmethodsretrofitexample.feature_meme_generator.domain.model.PostMemeModel
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*


interface MemeApis {
    @GET("user")
     fun getPost(): Call<List<MemeModel>>

    @DELETE("user/{id}")
    fun deletePost(@Path("id") id: String): Call<Unit>


    @PUT("/user/{id}")
    fun updateMeme(@Path("id") id: String, @Body requestBody: PostMemeModel): Call<PostMemeModel>

    @POST("/user")
    fun createEmployee(@Body requestBody: PostMemeModel): Call<ResponseBody>

    companion object {
        const val BASE_URL = "https://us-central1-rest-api-ed3bc.cloudfunctions.net"
    }
}