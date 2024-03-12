package com.example.timetonictest.login.local

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class LocalDataSource @Inject constructor(@ApplicationContext private val context: Context) {
    fun saveSessionKey(sessionKey: String) {
        context.getSharedPreferences("sessionKey", Context.MODE_PRIVATE).edit()
            .putString("sessionKey", sessionKey).apply()
    }

    fun getSessionKey() = context.getSharedPreferences("sessionKey", Context.MODE_PRIVATE)
}