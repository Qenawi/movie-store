package com.example.moviestorenew.home.data

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("id") val movieId: Int,
    @SerializedName("title") val title: String,
    @SerializedName("poster_path") val imageUrl: String?,
    @SerializedName("backdrop_path") val coverUrl: String?,
    @SerializedName("overview") val description: String,
    @SerializedName("vote_average") val rating: Float,
    @SerializedName("release_date") val releaseDate: String?,
    @SerializedName("genre_ids") val genreIds: List<Int>,
    @SerializedName("runtime") val duration: Int?
)
