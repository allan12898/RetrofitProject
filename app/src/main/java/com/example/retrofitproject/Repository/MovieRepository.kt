package com.example.retrofitproject.Repository

import android.R
import android.app.Activity
import android.util.Log
import com.example.retrofitproject.API.TmdbApi
import com.example.retrofitproject.MainActivity
import com.example.retrofitproject.Model.TmdbMovie
import com.example.retrofitproject.Model.TmdbMovieResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MovieRepository(private val api: TmdbApi, listeningActivity: Activity) : BaseRepository() {

    interface movieResponse {
        fun displayMovie(movieList: ArrayList<TmdbMovie>)
    }

    private val responseListener : movieResponse


    init {
        responseListener = listeningActivity as movieResponse
    }

    var result: ArrayList<TmdbMovie> = ArrayList()
    fun getMovieByKeyword(keyword: String, page: Int): ArrayList<TmdbMovie> {


        val movieResponse = api.getMovieByKeyword(keyword, page, "283a4046")

        movieResponse.enqueue(object : Callback<TmdbMovieResponse> {
            override fun onFailure(call: Call<TmdbMovieResponse>, t: Throwable) {

            }

            override fun onResponse(call: Call<TmdbMovieResponse>, response: Response<TmdbMovieResponse>) {
                if(response.isSuccessful){
                    println(call.request().url().toString())
                    var movies = response.body()!!.Search
                    responseListener.displayMovie(movies)
                }


                //result.addAll(response.body()!!.Search)

            }

        })

        Log.d("result", result.toString())
        return result


    }

    fun getMovieDetail(Id : String){
        val movieResponse = api.getMovieDetailById(Id)


    }


}