package com.example.moviestorenew.auth.register.ui


import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.moviestorenew.R

class RegisterFragment : Fragment(R.layout.register_fragment) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.btn).setOnClickListener {
            findNavController().navigate(RegisterFragmentDirections.actionRegisterFragmentToHomeFragment())
        }
    }
}