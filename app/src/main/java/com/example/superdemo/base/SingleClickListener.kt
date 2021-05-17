package com.example.superdemo.base

import android.os.SystemClock
import android.view.View

abstract class SingleClickListener(
    private val interval: Long = MIN_CLICK_INTERVAL
) : View.OnClickListener {

    companion object {
        const val MIN_CLICK_INTERVAL = 500L
    }

    private var mLastClickTime: Long = 0

    abstract fun onSingleClick(v: View?)

    override fun onClick(v: View?) {
        val currentClickTime = SystemClock.uptimeMillis()
        val elapsedTime: Long = currentClickTime - mLastClickTime
        mLastClickTime = currentClickTime
        if (elapsedTime <= interval) {
            return
        }
        onSingleClick(v)
    }
}