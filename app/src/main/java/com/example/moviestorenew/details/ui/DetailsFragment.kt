package com.example.moviestorenew.details.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.moviestorenew.R
import com.example.moviestorenew.home.data.ApiInterface
import com.example.moviestorenew.home.data.Movie
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailsFragment : Fragment(R.layout.details_fragment) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.backButton).setOnClickListener {
            view.findNavController().navigateUp()
        }

        val movieId: Int = requireArguments().get("movie_id").toString().toInt()
        val apiInterface = ApiInterface.create()
        apiInterface.getMovie(movieId, ApiInterface.API_KEY).enqueue(object : Callback<Movie?> {
            override fun onResponse(call: Call<Movie?>, response: Response<Movie?>) {
                if (response.body() != null) {
                    Picasso.get().load("${ApiInterface.IMAGE_URL}${response.body()!!.imageUrl}")
                        .into(
                            view.findViewById<ImageView>(R.id.posterImageView)
                        )
                    Picasso.get().load("${ApiInterface.COVER_URL}${response.body()!!.coverUrl}")
                        .into(
                            view.findViewById<ImageView>(R.id.coverImageView)
                        )
                    view.findViewById<TextView>(R.id.movieTitle_Details_TextView).text =
                        response.body()!!.title
                }
            }

            override fun onFailure(call: Call<Movie?>, t: Throwable) {
            }
        })
    }
}