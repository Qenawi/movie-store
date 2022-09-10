package com.example.moviestorenew.search.ui

import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.moviestorenew.R
import com.example.moviestorenew.home.data.Datasource

class SearchFragment : Fragment(R.layout.search_fragment) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val searchBar: EditText = view.findViewById(R.id.searchBar_EditText)
        searchBar.requestFocus()

        val moviesSearchRecyclerView: RecyclerView =
            view.findViewById(R.id.moviesSearch_recyclerView)
        moviesSearchRecyclerView.adapter = MoviesSearchAdapter(
            Datasource.getMovies(),
            requireContext()
        )

        searchBar.addTextChangedListener {
            (moviesSearchRecyclerView.adapter as MoviesSearchAdapter).setSearch(it.toString())
        }
    }
}