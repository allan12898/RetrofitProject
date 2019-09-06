package com.example.retrofitproject.API

import com.example.retrofitproject.Model.Category
import com.example.retrofitproject.Model.MovieDetail
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface QRApi {

    @GET("Categories")
    fun getAllCategories( @Query("i") id: String): Call<Category>
}