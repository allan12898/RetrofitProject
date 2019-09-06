package com.example.retrofitproject.API

import com.example.retrofitproject.Model.MovieDetail
import com.example.retrofitproject.Model.TmdbMovie
import com.example.retrofitproject.Model.TmdbMovieResponse
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TmdbApi{


    @GET("movie/popular")
    fun getPopularMovies() : Deferred<Response<TmdbMovieResponse>>


    @GET(".")
    fun getMovieDetailById( @Query("i") id: String): Call<MovieDetail>

    @GET(".")
    fun getMovieByKeyword(@Query("s") keyword:String,
                          @Query("page") page : Int,
                           @Query("apikey") key : String) : Deferred<Response<TmdbMovieResponse>>


}