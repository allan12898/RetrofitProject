package com.example.retrofitproject.ViewModel

import android.app.Activity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofitproject.API.Apifactory
import com.example.retrofitproject.Model.TmdbMovie
import com.example.retrofitproject.Repository.MovieRepository

class TmdbViewModel(activity : Activity) : ViewModel(){

    private val repository : MovieRepository = MovieRepository(Apifactory.tmdbApi,activity )

    fun fetchMovies( keyword: String ,page : Int) {

        if(keyword == ""){

        }
        else {

            repository.getMovieByKeyword(keyword , page )
        }

    }

    private lateinit var LiveMovieList : MutableLiveData<ArrayList<TmdbMovie>>

    fun fetchLiveMovie(keyword : String, page : Int){
        var movies = repository.getMovieByKeyword(keyword,page)

        LiveMovieList.postValue(movies)


    }



}