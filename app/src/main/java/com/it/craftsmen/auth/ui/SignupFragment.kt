package com.it.craftsmen.auth.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.it.craftsmen.R
import com.it.craftsmen.databinding.AuthSignupFragmentBinding

class SignupFragment : Fragment() {


    lateinit var binding: AuthSignupFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= AuthSignupFragmentBinding.inflate(layoutInflater)

        binding.tvForgetPasswordSignup.setOnClickListener {
            forgetPassword()
        }
        binding.tv2SignupMakeAccount.setOnClickListener {
            makeAccount()
        }
        return binding.root
    }

    private fun makeAccount() {
        findNavController().navigate(R.id.action_signupFragment_to_loginFragment)

    }
    private fun forgetPassword() {
        findNavController().navigate(R.id.action_signupFragment_to_forgotPasswordFragment)

    }


}