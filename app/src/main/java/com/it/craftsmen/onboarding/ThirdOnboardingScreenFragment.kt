package com.it.craftsmen.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.it.craftsmen.R
import com.it.craftsmen.databinding.FragmentThirdOnboardingScreenBinding

class ThirdOnboardingScreenFragment : Fragment() {
    lateinit var binding :FragmentThirdOnboardingScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentThirdOnboardingScreenBinding.inflate(layoutInflater)

        binding.btnStartNow.setOnClickListener {
            btnStartNowClicked()
        }

        return binding.root
    }

    private fun btnStartNowClicked() {
        findNavController().navigate(R.id.action_viewPagerFragment_to_loginFragment)
    }

}