package com.example.moviestorenew.home.data

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("discover/movie")
    fun discoverMovies(
        @Query("api_key") apiKey: String,
        @Query("sort_by") sortBy: String? = null,
        @Query("with_original_language") lang: String? = null,
        @Query("release_date.gte") releaseDateGTE: String? = null,
        @Query("release_date.lte") releaseDateLTE: String? = null
    ): Call<Discover>

    @GET("movie/now_playing")
    fun nowPlayingMovies(
        @Query("api_key") apiKey: String,
        @Query("page") page: Int
    ): Call<Discover>

    @GET("movie/upcoming")
    fun upcomingMovies(
        @Query("api_key") apiKey: String,
        @Query("page") page: Int
    ): Call<Discover>

    @GET("movie/popular")
    fun popularMovies(
        @Query("api_key") apiKey: String,
        @Query("page") page: Int
    ): Call<Discover>

    @GET("movie/top_rated")
    fun topRatedMovies(
        @Query("api_key") apiKey: String,
        @Query("page") page: Int
    ): Call<Discover>

    companion object {
        const val IMAGE_URL: String = "https://image.tmdb.org/t/p/w200/"
        private const val BASE_URL = "https://api.themoviedb.org/3/"
        const val API_KEY = "c0175ab2a6bb9a81ce9320280ec0c021"

        fun create(): ApiInterface {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build().create(ApiInterface::class.java)
        }
    }
}