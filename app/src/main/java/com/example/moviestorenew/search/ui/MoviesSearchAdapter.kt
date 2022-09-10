package com.example.moviestorenew.search.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.moviestorenew.R
import com.example.moviestorenew.home.data.Movie
import com.squareup.picasso.Picasso

class MoviesSearchAdapter(
    private val movies: List<Movie>,
    private val context: Context
) : RecyclerView.Adapter<MoviesSearchAdapter.MoviesSearchViewHolder>() {
    private var displayedMovies: List<Movie> = listOf()

    class MoviesSearchViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.roundedImageView)
        val titleTextView: TextView = view.findViewById(R.id.movie_title_textView)
        val genreTextView: TextView = view.findViewById(R.id.movie_genre_textView)
        val yearTextView: TextView = view.findViewById(R.id.movie_year_textView)
        val durationTextView: TextView = view.findViewById(R.id.movie_duration_textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesSearchViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.movie_search_card, parent, false
        )
        return MoviesSearchViewHolder(view)
    }

    override fun onBindViewHolder(holder: MoviesSearchViewHolder, position: Int) {
        Picasso.get().load(displayedMovies[position].imageURL).into(holder.imageView)
        holder.titleTextView.text = displayedMovies[position].title
        holder.genreTextView.text = displayedMovies[position].genre
        holder.yearTextView.text = "${displayedMovies[position].year}"
        holder.durationTextView.text = context.getString(R.string.x_minutes, displayedMovies[position].duration)
    }

    override fun getItemCount() = displayedMovies.size

    fun setSearch(query: String) {
        displayedMovies = movies.filter {
            it.title.contains(query)
        }
        notifyDataSetChanged()
    }

}
