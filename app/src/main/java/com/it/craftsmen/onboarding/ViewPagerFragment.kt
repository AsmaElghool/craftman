package com.it.craftsmen.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.viewpager2.widget.ViewPager2
import com.it.craftsmen.R
import com.it.craftsmen.adapter.ViewPagerAdapter
import com.it.craftsmen.databinding.OnboardingViewPagerFragmentBinding
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator


class ViewPagerFragment : Fragment() {

    lateinit var binding: OnboardingViewPagerFragmentBinding
    private lateinit var viewPager: ViewPager2
    private val fragments = listOf(
        FirstOnboardingScreenFragment(),
        SecondOnboardingScreenFragment(),
        ThirdOnboardingScreenFragment()
    )
    private var currentPage = 0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = OnboardingViewPagerFragmentBinding.inflate(layoutInflater)
        viewPager = binding.viewPager
        initViewPager()

        // Handle backStack
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    if (currentPage > 0) {
                        viewPager.currentItem = currentPage - 1
                    } else {
                        requireActivity().finish()
                    }
                }
            })

        return binding.root
    }

    private fun initViewPager() {
        val pagerAdapter = ViewPagerAdapter(childFragmentManager, fragments, lifecycle)
        binding.viewPager.adapter = pagerAdapter
        val indicator: DotsIndicator = binding.dotsIndicator
        indicator.setViewPager2(binding.viewPager)

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                currentPage = position
                updateNextButtonVisibility(position)
                updateArrowBackVisibility(position)
            }
        })
    }

    private fun updateArrowBackVisibility(position: Int) {

        when (fragments[currentPage]) {
            is FirstOnboardingScreenFragment -> {
                binding.icOnboardingSkip.visibility = View.INVISIBLE
            }

            is SecondOnboardingScreenFragment, is ThirdOnboardingScreenFragment -> {
                binding.icOnboardingSkip.visibility = View.VISIBLE
                binding.icOnboardingSkip.setOnClickListener {
                    viewPager.currentItem = currentPage - 1
                }
            }
        }

    }

    private fun updateNextButtonVisibility(position: Int) {
        when (fragments[currentPage]) {
            is FirstOnboardingScreenFragment, is SecondOnboardingScreenFragment -> {
                binding.onboardingNextBtn.visibility = View.VISIBLE
                binding.onboardingNextBtn.setOnClickListener {
                    viewPager.currentItem = currentPage + 1
                }
            }

            is ThirdOnboardingScreenFragment -> {
                binding.onboardingNextBtn.visibility = View.INVISIBLE
            }
        }
    }

}