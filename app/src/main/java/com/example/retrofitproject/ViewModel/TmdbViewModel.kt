package com.example.retrofitproject.ViewModel

import android.app.Activity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofitproject.API.Apifactory
import com.example.retrofitproject.Model.TmdbMovie
import com.example.retrofitproject.Repository.MovieRepository
import com.example.retrofitproject.Repository.Result
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class TmdbViewModel : ViewModel(){

    //private val repository : MovieRepository = MovieRepository(Apifactory.tmdbApi,activity )

    private val repository : MovieRepository = MovieRepository(Apifactory.tmdbApi )



    suspend fun fetchMovies( keyword: String ,page : Int) {

        if(keyword == ""){

        }
        else {

            repository.getMovieByKeyword(keyword , page )
        }

    }

      var LiveMovieList  =  MutableLiveData<ArrayList<TmdbMovie>>()

     fun fetchLiveMovie(keyword : String, page : Int){
         GlobalScope.launch {
             var movies = repository.getMovieByKeyword(keyword, page)
                 LiveMovieList.postValue(movies)

         }


    }



}