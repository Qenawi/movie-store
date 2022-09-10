package com.example.moviestorenew.home.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.moviestorenew.R
import com.example.moviestorenew.home.data.Movie
import com.squareup.picasso.Picasso

class TopMoviesAdapter(
    private val movies: List<Movie>
) : RecyclerView.Adapter<TopMoviesAdapter.TopMoviesViewHolder>() {
    class TopMoviesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.roundedImageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopMoviesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_card, parent, false)
        return TopMoviesViewHolder(view)
    }

    override fun onBindViewHolder(holder: TopMoviesViewHolder, position: Int) {
        Picasso.get().load(movies[position].imageURL).into(holder.imageView)
    }

    override fun getItemCount() = movies.size
}


