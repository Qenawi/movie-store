package com.example.moviestorenew.watchlist.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.moviestorenew.R

class WatchlistFragment : Fragment(R.layout.watchlist_fragment) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.loginWatchlist).setOnClickListener {
            view.findNavController()
                .navigate(WatchlistFragmentDirections.actionWatchlistFragmentToLoginFragment())
        }
    }
}
