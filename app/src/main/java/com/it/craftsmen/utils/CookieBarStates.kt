package com.it.craftsmen.utils

import androidx.fragment.app.Fragment
import com.it.craftsmen.R
import org.aviran.cookiebar2.CookieBar


/**
 * Show a customizable CookieBar with dynamic title and message.
 */
fun Fragment.showSuccessCookieBar(
    title: String,
    message: String,
) {
    CookieBar.build(activity)
        .setTitle(title)
        .setBackgroundColor(R.color.purple_200)
        .setTitleColor(R.color.white)
        .setIcon(R.drawable.ic_launcher_background)
        .setMessage(message)
        .setDuration(3500)
        .setEnableAutoDismiss(true)
        .setCookiePosition(CookieBar.TOP)
        .show()
}


fun Fragment.showWarningCookieBar(
    title: String,
    message: String,
) {
    CookieBar.build(activity)
        .setTitle(title)
        .setBackgroundColor(R.color.purple_200)
        .setTitleColor(R.color.white)
        .setIcon(R.drawable.ic_launcher_background)
        .setMessage(message)
        .setDuration(5000)
        .setEnableAutoDismiss(true)
        .setCookiePosition(CookieBar.TOP)
        .show()
}

fun Fragment.showFailedCookieBar(
    title: String,
    message: String,
) {
    CookieBar.build(activity)
        .setTitle(title)
        .setBackgroundColor(R.color.purple_200)
        .setTitleColor(R.color.white)
        .setIcon(R.drawable.ic_launcher_background)
        .setMessage(message)
        .setDuration(4000)
        .setEnableAutoDismiss(true)
        .setCookiePosition(CookieBar.BOTTOM)
        .show()
}
