package com.example.tugasppb.utils

import android.os.StrictMode

object ThreadPolicy {
    var policy: StrictMode.ThreadPolicy? = null
    fun call() {
        if (policy != null) {
            policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
            StrictMode.setThreadPolicy(policy);
        }
    }

}