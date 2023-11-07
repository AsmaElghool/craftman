package com.it.craftsmen.utils

import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment

/**
 * handle back button in fragment
 */
fun Fragment.handleBackButtonInFragment(onClick: () -> Unit) {
    requireActivity().onBackPressedDispatcher
        .addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                onClick.invoke()
            }
        })
}














