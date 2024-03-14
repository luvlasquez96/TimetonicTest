package com.example.timetonictest.login.data.local

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class LocalDataSource @Inject constructor(@ApplicationContext private val context: Context) {

    private val sharedPreferences = context.getSharedPreferences(SESSION_KEY, Context.MODE_PRIVATE)
    fun saveSessionKey(sessionKey: String) {
        sharedPreferences.edit()
            .putString(SESSION_KEY, sessionKey).apply()
    }

    fun getSessionKey(): String =
        sharedPreferences.getString(SESSION_KEY, "")
            ?: ""
}

const val SESSION_KEY = "sessionKey"