package com.example.moviestorenew.home.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.moviestorenew.R
import com.example.moviestorenew.home.data.Datasource
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout

class HomeFragment : Fragment(R.layout.home_fragment) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val moviesRecyclerView: RecyclerView = view.findViewById(R.id.moviesGrid_recyclerView)
        moviesRecyclerView.adapter = MoviesAdapter(
            Datasource.getMovies() + Datasource.getMovies() + Datasource.getMovies() +
                    Datasource.getMovies() + Datasource.getMovies() + Datasource.getMovies() +
                    Datasource.getMovies() + Datasource.getMovies() + Datasource.getMovies()
        )

        val searchBar: Button = view.findViewById(R.id.searchBar_button)
        searchBar.setOnClickListener {
            activity?.findViewById<BottomNavigationView>(R.id.bottom_nav)?.selectedItemId =
                R.id.searchFragment
        }

        val tabLayout: TabLayout = view.findViewById(R.id.tabLayout)
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.text) {
                    getString(R.string.now_playing) -> {
//                        (moviesRecyclerView.adapter as MoviesAdapter).filterMovies("Jurassic World Dominion")
                    }
                    getString(R.string.upcoming) -> {
//                        (moviesRecyclerView.adapter as MoviesAdapter).filterMovies("Jurassic World Dominion")
                    }
                    getString(R.string.top_rated) -> {
//                        (moviesRecyclerView.adapter as MoviesAdapter).filterMovies("The Godfather")
                    }
                    getString(R.string.popular) -> {
//                        (moviesRecyclerView.adapter as MoviesAdapter).resetMovies()
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })

        val topMoviesRecyclerView: RecyclerView = view.findViewById(R.id.topMovies_recyclerView)
        topMoviesRecyclerView.adapter = TopMoviesAdapter(Datasource.getTopMovies())
    }
}