package com.example.moviestorenew.auth.login.ui


import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController

import com.example.moviestorenew.R

class LoginFragment : Fragment(R.layout.login_fragment) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.doNotHaveAccount).setOnClickListener {
            view.findNavController()
                .navigate(LoginFragmentDirections.actionLoginFragmentToRegisterFragment())
        }
    }
}