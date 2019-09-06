package com.example.retrofitproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.retrofitproject.Model.TmdbMovie
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_movie_detail.*

class MovieDetailActivity : AppCompatActivity() {

    private lateinit var movie : TmdbMovie
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        movie = intent.getSerializableExtra(MOVIEDETAIL) as TmdbMovie
        Picasso.get().load(movie.Poster).into(poster)

    }

    companion object{
        private val MOVIEDETAIL = "MOVIE"
    }
}
