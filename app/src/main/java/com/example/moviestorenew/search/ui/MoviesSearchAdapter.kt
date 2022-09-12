package com.example.moviestorenew.search.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.moviestorenew.R
import com.example.moviestorenew.home.data.ApiInterface
import com.example.moviestorenew.home.data.Discover
import com.example.moviestorenew.home.data.Genre
import com.example.moviestorenew.home.data.Movie
import com.squareup.picasso.Picasso

class MoviesSearchAdapter : RecyclerView.Adapter<MoviesSearchAdapter.MoviesSearchViewHolder>() {
    private val displayedMovies = mutableListOf<Movie>()

    class MoviesSearchViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.roundedImageView)
        val titleTextView: TextView = view.findViewById(R.id.movie_title_textView)
        val genreTextView: TextView = view.findViewById(R.id.movie_genre_textView)
        val yearTextView: TextView = view.findViewById(R.id.movie_year_textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesSearchViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.movie_search_card, parent, false
        )
        val holder = MoviesSearchViewHolder(view)
        holder.view.setOnClickListener {
            holder.view.findNavController().navigate(
                SearchFragmentDirections.actionSearchFragmentToDetailsFragment(
                    displayedMovies[holder.adapterPosition].movieId
                )
            )
        }
        return holder
    }

    override fun onBindViewHolder(holder: MoviesSearchViewHolder, position: Int) {
        Picasso.get().load("${ApiInterface.IMAGE_URL}${displayedMovies[position].imageUrl!!}")
            .into(holder.imageView)
        holder.titleTextView.text = displayedMovies[position].title
        holder.genreTextView.text =
            displayedMovies[position].genreIds.joinToString(", ") { gid: Int ->
                Genre.values().first { it.genreId == gid }.genreName
            }
        holder.yearTextView.text = displayedMovies[position].releaseDate?.split("-")?.get(0)
    }

    override fun getItemCount() = displayedMovies.size

    fun setMovies(movies: Discover) {
        displayedMovies.clear()
        displayedMovies.addAll(movies.results.filter {
            it.imageUrl != null
        })
        notifyDataSetChanged()
    }

    fun addMovies(movies: Discover) {
        displayedMovies.addAll(movies.results.filter {
            it.imageUrl != null
        })
        notifyDataSetChanged()
    }
}
