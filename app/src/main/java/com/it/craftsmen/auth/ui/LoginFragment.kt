package com.it.craftsmen.auth.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.it.craftsmen.R
import com.it.craftsmen.databinding.AuthLoginFragmentBinding


class LoginFragment : Fragment() {

    lateinit var binding: AuthLoginFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= AuthLoginFragmentBinding.inflate(layoutInflater)

        binding.tv2LoginToSignup.setOnClickListener {
            signup()
        }
        return binding.root
    }

    private fun signup() {
        findNavController().navigate(R.id.action_loginFragment_to_signupFragment)

    }
}