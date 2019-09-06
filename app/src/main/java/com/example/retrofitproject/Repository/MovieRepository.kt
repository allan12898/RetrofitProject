package com.example.retrofitproject.Repository

import com.example.retrofitproject.API.TmdbApi
import com.example.retrofitproject.Model.TmdbMovie


class MovieRepository(private val api: TmdbApi) : BaseRepository() {

    interface movieResponse {
        fun displayMovie(movieList: ArrayList<TmdbMovie>)
    }

    //private val responseListener : movieResponse



    init {
        //responseListener = listeningActivity as movieResponse
    }


    var result: ArrayList<TmdbMovie> = ArrayList()
    suspend fun getMovieByKeyword(keyword: String, page: Int) : ArrayList<TmdbMovie> {


        //val movieResponse = api.getMovieByKeyword(keyword, page, "283a4046")
        val movieResponse = safeApiCall(
            call = {api.getMovieByKeyword(keyword, page,"283a4046" ).await()},
            errorMessage = "Error Fetching Popular Movies"
        )
        return movieResponse!!.Search




//        val response = movieResponse.invoke()
//        if (response.isSuccessful)
//            Log.d("result", response.body()!!.Search.toString())
//            return response.body()!!.Search

//        movieResponse.enqueue(object : Callback<TmdbMovieResponse> {
//            override fun onFailure(call: Call<TmdbMovieResponse>, t: Throwable) {
//
//            }
//
//            override fun onResponse(call: Call<TmdbMovieResponse>, response: Response<TmdbMovieResponse>) {
//                if(response.isSuccessful){
//
//                    println(call.request().url().toString())
//
//                    var movielist = response.body()!!.Search
//                    result = movielist
//                    Result.Success(movielist)
//
//                    //var movies = response.body()!!.Search
//                    //responseListener.displayMovie(movies)
//                }
//
//
//                //result.addAll(response.body()!!.Search)
//
//            }
//
//        })


//        return result


    }

    fun getMovieDetail(Id : String){

        val movieResponse = api.getMovieDetailById(Id)



    }




}