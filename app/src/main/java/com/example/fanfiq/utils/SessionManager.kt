package com.example.fanfiq.utils

import android.content.Context
import android.content.SharedPreferences
import com.example.fanfiq.MainActivity
import com.example.fanfiq.R

/**
 * Session manager to save and fetch data from SharedPreferences
 */
class SessionManager(context: MainActivity) {
    private var prefs: SharedPreferences = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)

    companion object {
        const val USER_TOKEN = "logout"
        const val CURRENT_USER_EMAIL = "email"
        const val CURRENT_USER_USERNAME = "username"
    }

    /**
     * Function to save auth token
     */
    fun saveAuthToken(token: String) {
        val editor = prefs.edit()
        editor.putString(USER_TOKEN, token)
        editor.apply()
    }

    fun saveEmail(email: String) {
        val editor = prefs.edit()
        editor.putString(CURRENT_USER_EMAIL, email)
        editor.apply()
    }

    fun saveUsername(username: String) {
        val editor = prefs.edit()
        editor.putString(CURRENT_USER_USERNAME, username)
        editor.apply()
    }

    /**
     * Function to fetch auth token
     */
    fun fetchAuthToken(): String? {
        return prefs.getString(USER_TOKEN, null)
    }

    fun fetchEmail(): String? {
        return prefs.getString(CURRENT_USER_EMAIL, null)
    }

    fun fetchUsername(): String? {
        return prefs.getString(CURRENT_USER_USERNAME, null)
    }
}