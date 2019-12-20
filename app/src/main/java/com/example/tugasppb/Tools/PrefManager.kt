package com.example.tugasppb.Tools

import android.content.Context
import android.content.SharedPreferences


class PrefManager(val context: Context) {

    private val PRIVATE_MODE = 0
    private val PREF_NAME = "sciShowcasePreferences"
    private val SHOW_APP_INTRO = "showAppIntro"

    private var preferences: SharedPreferences? = null

    var showAppIntro: Boolean
        get() = preferences!!.getBoolean(SHOW_APP_INTRO, true)
        set(value) {
            val preferencesEditor = preferences!!.edit()
            preferencesEditor.putBoolean(SHOW_APP_INTRO, value)
            preferencesEditor.apply()
        }

    init {
        preferences = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE)
    }
}