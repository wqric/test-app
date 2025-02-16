package com.example.ct.data.sharedPrefs

import android.content.Context
import androidx.core.content.edit

class SharedPrefs(context: Context) {
    companion object {
        private const val SHARED_PREFS_KEY = "FREWFGRWE"
        private const val ONBOARDING_STATE_KEY = "REWGRTWG"
        private const val IS_AUTH_STATE = "FRQEWR"
    }

    private val sharedPrefs = context.getSharedPreferences(SHARED_PREFS_KEY, Context.MODE_PRIVATE)

    var onBoardingState: Boolean
        get() = sharedPrefs.getBoolean(ONBOARDING_STATE_KEY, false)
        set(value) {
            sharedPrefs.edit {putBoolean(ONBOARDING_STATE_KEY, value)}
        }
    var isAuthState: Boolean
        get() = sharedPrefs.getBoolean(IS_AUTH_STATE, false)
        set(value) {
            sharedPrefs.edit {putBoolean(IS_AUTH_STATE, value)}
        }
}
