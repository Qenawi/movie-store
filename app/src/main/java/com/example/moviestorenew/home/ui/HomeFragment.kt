package com.example.moviestorenew.home.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.moviestorenew.R
import com.example.moviestorenew.home.data.Datasource

class HomeFragment : Fragment(R.layout.home_fragment) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val topMoviesRecyclerView: RecyclerView = view.findViewById(R.id.topMovies_recyclerView)
        topMoviesRecyclerView.adapter = TopMoviesAdapter(Datasource.getMovies())
    }
}