package com.yadokari.tv.mvvmbase.utils

import android.util.Log
import androidx.multidex.BuildConfig

object LogUtils {
    private const val TAG = "MvvmBase"

    fun d(text: String) {
        if (BuildConfig.DEBUG) Log.d(TAG, text)
    }

    fun d(tag: String, text: String) {
        if (BuildConfig.DEBUG) Log.d(tag, text)
    }

    fun e(text: String) {
        if (BuildConfig.DEBUG) Log.e(TAG, text)
    }

    fun e(tag: String, text: String) {
        if (BuildConfig.DEBUG) Log.e(tag, text)
    }

    fun i(text: String) {
        if (BuildConfig.DEBUG) Log.i(TAG, text)
    }

    fun i(tag: String, text: String) {
        if (BuildConfig.DEBUG) Log.i(tag, text)
    }

    fun w(text: String) {
        if (BuildConfig.DEBUG) Log.w(TAG, text)
    }

    fun w(tag: String, text: String) {
        if (BuildConfig.DEBUG) Log.w(tag, text)
    }
}