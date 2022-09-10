package com.example.moviestorenew.home.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.moviestorenew.R
import com.example.moviestorenew.home.data.Movie
import com.squareup.picasso.Picasso

class MoviesAdapter(
    private val movies: List<Movie>
) : RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {
    private var displayedMovies = movies

    class MoviesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.roundedImageView)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MoviesAdapter.MoviesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_card, parent, false)
        return MoviesAdapter.MoviesViewHolder(view)
    }

    override fun onBindViewHolder(holder: MoviesAdapter.MoviesViewHolder, position: Int) {
        Picasso.get().load(displayedMovies[position].imageURL).into(holder.imageView)
    }

    override fun getItemCount() = displayedMovies.size

    fun filterMovies(title: String) {
        displayedMovies = movies.filter {
            it.title == title
        }
        notifyDataSetChanged()
    }

    fun resetMovies() {
        displayedMovies = movies
        notifyDataSetChanged()
    }

}
