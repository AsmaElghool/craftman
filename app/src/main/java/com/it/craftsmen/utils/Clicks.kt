package com.it.craftsmen.utils

import android.os.SystemClock
import android.view.View

/**
 * make a time space between click and another click
 * */
fun View.clickWithThrottle(throttleTime: Long = 1000L, action: () -> Unit) {
    this.setOnClickListener(object : View.OnClickListener {

        private var lastClickTime: Long = 0

        override fun onClick(v: View) {
            if (SystemClock.elapsedRealtime() - lastClickTime < throttleTime) return
            else action()

            lastClickTime = SystemClock.elapsedRealtime()
        }
    })
}
