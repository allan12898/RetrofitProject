package com.example.retrofitproject.View

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitproject.Model.TmdbMovie
import com.example.retrofitproject.R
import android.view.LayoutInflater
import androidx.lifecycle.MutableLiveData
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_row.view.*


class MovieAdapter(private val MovieList: MutableList<TmdbMovie>, itemOnClickListener: ItemOnClickListener) : RecyclerView.Adapter<MovieHolder>() {
    private var _itemOnClickListener = itemOnClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val view = MovieHolder(LayoutInflater.from(parent.context).inflate(R.layout.movie_row, parent, false),_itemOnClickListener)
        return view

    }

    override fun getItemCount(): Int {
        return MovieList.size
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        val movie = MovieList[position]
        holder.bindMovie(movie)
    }


}

class MovieHolder(v: View, itemOnClick : ItemOnClickListener) : RecyclerView.ViewHolder(v), View.OnClickListener {

    private var onClickListener : ItemOnClickListener
    init {
        onClickListener = itemOnClick
        v.setOnClickListener(this)
    }

    private var view : View = v
    fun bindMovie(movie : TmdbMovie){
        Picasso.get().load(movie.Poster).into(view.movie_img)
        view.title.text = movie.Title
    }

    override fun onClick(p0: View?) {
        onClickListener.onClick(view,adapterPosition )
    }
}

interface ItemOnClickListener{
    fun onClick(view : View, position : Int)
    fun onLongClick()
}