package com.example.httpmethodsretrofitexample.feature_meme_generator.data.remote

import com.example.httpmethodsretrofitexample.feature_meme_generator.domain.model.Data_Type
import com.example.httpmethodsretrofitexample.feature_meme_generator.domain.model.model
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*


interface APIService {
    @GET("user")
     fun getPost(): Call<List<Data_Type>>

    @DELETE("user/{id}")
    fun deletePost(@Path("id") id: String): Call<Unit>


    @PUT("/user/{id}")
    fun updateMeme(@Path("id") id: String, @Body requestBody: model): Call<model>

    @POST("/user")
    fun createEmployee(@Body requestBody: model): Call<ResponseBody>

    companion object {
        const val BASE_URL = "https://us-central1-rest-api-ed3bc.cloudfunctions.net"
    }
}