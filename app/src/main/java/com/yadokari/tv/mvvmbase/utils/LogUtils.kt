package com.yadokari.tv.mvvmbase.utils

import android.util.Log
import androidx.multidex.BuildConfig

object LogUtils {

    private const val TAG = "MVVMBase"

    fun d(text: String) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, text)
        }
    }

    fun d(tag: String, text: String) {
        if (BuildConfig.DEBUG) {
            Log.d(tag, text)
        }
    }

    fun e(text: String) {
        if (BuildConfig.DEBUG) {
            Log.e(TAG, text)
        }
    }

    fun e(tag: String, text: String) {
        if (BuildConfig.DEBUG) {
            Log.e(tag, text)
        }
    }
}