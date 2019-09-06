package com.example.retrofitproject.Model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class TmdbMovie(
   val Type: String,
     val Title: String,
    val imdbID: String,
    val Poster : String
) : Serializable