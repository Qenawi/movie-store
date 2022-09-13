package com.example.moviestorenew.home.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.moviestorenew.R
import com.example.moviestorenew.home.data.ApiInterface
import com.example.moviestorenew.home.data.Discover
import com.example.moviestorenew.home.data.Movie
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment(R.layout.home_fragment) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var latestPage = 1

        val apiInterface = ApiInterface.create()
        val tabLayout: TabLayout = view.findViewById(R.id.tabLayout)

        val moviesRecyclerView: RecyclerView = view.findViewById(R.id.moviesGrid_recyclerView)
        moviesRecyclerView.adapter = MoviesAdapter()

        moviesRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)

                if (!recyclerView.canScrollVertically(1)) {
                    latestPage++
                    when (tabLayout.getTabAt(tabLayout.selectedTabPosition)?.text) {
                        getString(R.string.now_playing) -> {
                            apiInterface.nowPlayingMovies(
                                ApiInterface.API_KEY,
                                page = latestPage
                            )
                                .enqueue(object : Callback<Discover?> {
                                    override fun onResponse(
                                        call: Call<Discover?>,
                                        response: Response<Discover?>
                                    ) {
                                        if (response.body() != null) {
                                            (moviesRecyclerView.adapter as MoviesAdapter)
                                                .addMovies(response.body()!!)
                                        }
                                    }

                                    override fun onFailure(
                                        call: Call<Discover?>,
                                        t: Throwable
                                    ) {
                                    }
                                })
                        }
                        getString(R.string.upcoming) -> {
                            apiInterface.upcomingMovies(
                                ApiInterface.API_KEY,
                                page = latestPage
                            )
                                .enqueue(object : Callback<Discover?> {
                                    override fun onResponse(
                                        call: Call<Discover?>,
                                        response: Response<Discover?>
                                    ) {
                                        if (response.body() != null) {
                                            (moviesRecyclerView.adapter as MoviesAdapter)
                                                .addMovies(response.body()!!)
                                        }
                                    }

                                    override fun onFailure(
                                        call: Call<Discover?>,
                                        t: Throwable
                                    ) {
                                    }
                                })
                        }
                        getString(R.string.top_rated) -> {
                            apiInterface.topRatedMovies(
                                ApiInterface.API_KEY,
                                page = latestPage
                            )
                                .enqueue(object : Callback<Discover?> {
                                    override fun onResponse(
                                        call: Call<Discover?>,
                                        response: Response<Discover?>
                                    ) {
                                        if (response.body() != null) {
                                            (moviesRecyclerView.adapter as MoviesAdapter)
                                                .addMovies(response.body()!!)
                                        }
                                    }

                                    override fun onFailure(call: Call<Discover?>, t: Throwable) {
                                    }
                                })
                        }
                        getString(R.string.popular) -> {
                            apiInterface.popularMovies(
                                ApiInterface.API_KEY,
                                page = latestPage
                            )
                                .enqueue(object : Callback<Discover?> {
                                    override fun onResponse(
                                        call: Call<Discover?>,
                                        response: Response<Discover?>
                                    ) {
                                        if (response.body() != null) {
                                            (moviesRecyclerView.adapter as MoviesAdapter)
                                                .addMovies(response.body()!!)
                                        }
                                    }

                                    override fun onFailure(call: Call<Discover?>, t: Throwable) {
                                    }
                                })
                        }
                    }
                }
            }
        })

        val latestMoviesRecyclerView: RecyclerView = view.findViewById(R.id.topMovies_recyclerView)
        latestMoviesRecyclerView.adapter = LatestMoviesAdapter()


        apiInterface.latestMovies(
            ApiInterface.API_KEY
        ).enqueue(object : Callback<Discover?> {
            override fun onResponse(call: Call<Discover?>, response: Response<Discover?>) {
                if (response.body() != null) {
                    (latestMoviesRecyclerView.adapter as LatestMoviesAdapter).setMovies(
                        response.body()!!
                    )
                }
            }

            override fun onFailure(call: Call<Discover?>, t: Throwable) {}
        })


        val searchBar: Button = view.findViewById(R.id.searchBar_button)
        searchBar.setOnClickListener {
            requireActivity()
                .findViewById<BottomNavigationView>(R.id.bottom_nav)
                .selectedItemId = R.id.searchFragment
        }

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                latestPage = 1
                when (tab?.text) {
                    getString(R.string.now_playing) -> {
                        apiInterface.nowPlayingMovies(
                            ApiInterface.API_KEY,
                            page = latestPage
                        )
                            .enqueue(object : Callback<Discover?> {
                                override fun onResponse(
                                    call: Call<Discover?>,
                                    response: Response<Discover?>
                                ) {
                                    if (response.body() != null) {
                                        (moviesRecyclerView.adapter as MoviesAdapter)
                                            .setMovies(response.body()!!)
                                    }
                                }

                                override fun onFailure(call: Call<Discover?>, t: Throwable) {
                                }
                            })
                    }
                    getString(R.string.upcoming) -> {
                        apiInterface.upcomingMovies(
                            ApiInterface.API_KEY,
                            page = latestPage
                        )
                            .enqueue(object : Callback<Discover?> {
                                override fun onResponse(
                                    call: Call<Discover?>,
                                    response: Response<Discover?>
                                ) {
                                    if (response.body() != null) {
                                        (moviesRecyclerView.adapter as MoviesAdapter)
                                            .setMovies(response.body()!!)
                                    }
                                }

                                override fun onFailure(call: Call<Discover?>, t: Throwable) {
                                }
                            })
                    }
                    getString(R.string.top_rated) -> {
                        apiInterface.topRatedMovies(
                            ApiInterface.API_KEY,
                            page = latestPage
                        )
                            .enqueue(object : Callback<Discover?> {
                                override fun onResponse(
                                    call: Call<Discover?>,
                                    response: Response<Discover?>
                                ) {
                                    if (response.body() != null) {
                                        (moviesRecyclerView.adapter as MoviesAdapter)
                                            .setMovies(response.body()!!)
                                    }
                                }

                                override fun onFailure(call: Call<Discover?>, t: Throwable) {
                                }
                            })
                    }
                    getString(R.string.popular) -> {
                        apiInterface.popularMovies(
                            ApiInterface.API_KEY,
                            page = latestPage
                        )
                            .enqueue(object : Callback<Discover?> {
                                override fun onResponse(
                                    call: Call<Discover?>,
                                    response: Response<Discover?>
                                ) {
                                    if (response.body() != null) {
                                        (moviesRecyclerView.adapter as MoviesAdapter)
                                            .setMovies(response.body()!!)
                                    }
                                }

                                override fun onFailure(call: Call<Discover?>, t: Throwable) {
                                }
                            })
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                (moviesRecyclerView.adapter as MoviesAdapter)
                    .setMovies(Discover(listOf<Movie>()))
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })

        tabLayout.getTabAt(1)?.select()
        tabLayout.getTabAt(0)?.select()

    }
}