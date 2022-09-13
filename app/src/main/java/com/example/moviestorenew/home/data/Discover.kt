package com.example.moviestorenew.home.data

import com.google.gson.annotations.SerializedName

data class Discover(
//    @SerializedName("page") val page: Int,
    @SerializedName("results") val results: List<Movie>
//    @SerializedName("total_pages") val totalPages: Int,
//    @SerializedName("results") val totalResults: Int
)