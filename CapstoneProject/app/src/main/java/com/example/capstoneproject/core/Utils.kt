package com.example.capstoneproject.core

import android.util.Log
import com.example.capstoneproject.core.Constants.TAG

class Utils {
    companion object {
        fun print(e: Exception?) {
            Log.d(TAG, e?.message ?: e.toString())
        }
    }
}