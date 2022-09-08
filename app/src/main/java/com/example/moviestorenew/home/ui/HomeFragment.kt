package com.example.moviestorenew.home.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.moviestorenew.R
import com.example.moviestorenew.auth.login.ui.LoginFragmentDirections

class HomeFragment : Fragment(R.layout.home_fragment) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.btn).setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDetailsFragment())
        }
    }
}