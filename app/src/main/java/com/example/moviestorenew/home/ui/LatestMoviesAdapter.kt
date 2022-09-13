package com.example.moviestorenew.home.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.moviestorenew.R
import com.example.moviestorenew.home.data.ApiInterface
import com.example.moviestorenew.home.data.Discover
import com.example.moviestorenew.home.data.Movie
import com.squareup.picasso.Picasso

class LatestMoviesAdapter : RecyclerView.Adapter<LatestMoviesAdapter.LatestMoviesViewHolder>() {
    private var displayedMovies = listOf<Movie>()

    class LatestMoviesViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.roundedImageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LatestMoviesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.top_movie_card, parent, false)
        val holder = LatestMoviesViewHolder(view)
        holder.view.setOnClickListener {
            holder.view.findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToDetailsFragment(
                    displayedMovies[holder.adapterPosition].movieId
                )
            )
        }
        return holder
    }

    override fun onBindViewHolder(holder: LatestMoviesViewHolder, position: Int) {
        Picasso.get().load("${ApiInterface.IMAGE_URL}${displayedMovies[position].imageUrl!!}")
            .into(holder.imageView)
    }

    override fun getItemCount() = displayedMovies.size

    fun setMovies(movies: Discover) {
        displayedMovies = movies.results.filter {
            it.imageUrl != null
        }
        notifyDataSetChanged()
    }
}


