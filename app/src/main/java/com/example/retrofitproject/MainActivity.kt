package com.example.retrofitproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitproject.API.Apifactory
import com.example.retrofitproject.Model.TmdbMovie
import com.example.retrofitproject.Repository.MovieRepository
import com.example.retrofitproject.View.ItemOnClickListener
import com.example.retrofitproject.View.MovieAdapter
import com.example.retrofitproject.ViewModel.TmdbViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MovieRepository.movieResponse, ItemOnClickListener {



    private lateinit var tmdbViewModel: TmdbViewModel
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter: MovieAdapter
    private  var MovieList : ArrayList<TmdbMovie> = ArrayList()

    var keyword: String = "nice"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecycleView()

        search_button.setOnClickListener{
            keyword = SearchBox.text.toString()
            getMovies(keyword)
        }

    }

    override fun onStart() {
        super.onStart()
        getMovies(keyword)

    }

    override fun onLongClick() {

    }
    fun initRecycleView(){
        linearLayoutManager = LinearLayoutManager(this)

        //tmdbViewModel = TmdbViewModel(this)
        tmdbViewModel = ViewModelProviders.of(this).get(TmdbViewModel::class.java)

        movie_rv.layoutManager = linearLayoutManager
        adapter = MovieAdapter(MovieList,this)
        movie_rv.adapter = adapter
    }

    override fun onClick(view: View, position: Int) {

        var intent = Intent(this,MovieDetailActivity::class.java)
        intent.putExtra(MOVIEDETAIL,MovieList[position])
        this.startActivity(intent)
    }

    fun getMovies(searchString : String){
            //tmdbViewModel.fetchMovies(searchString, 1)
        tmdbViewModel.fetchLiveMovie(searchString, 1)
        tmdbViewModel.LiveMovieList.observe(this, Observer {
            c ->

            MovieList.clear()
            MovieList.addAll(c)
            adapter.notifyDataSetChanged()
            Log.d("result", c.toString())
        })


    }

    override fun displayMovie(newMovieList: ArrayList<TmdbMovie>) {

//        MovieList.clear()
//        MovieList.addAll(newMovieList)
//        adapter.notifyDataSetChanged()
//        Log.d("movie", MovieList.toString())
    }

    companion object {
        //5
        private val MOVIEDETAIL  = "MOVIE"
    }
}
