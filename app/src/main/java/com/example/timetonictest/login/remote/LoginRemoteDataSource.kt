package com.example.timetonictest.login.remote

import android.content.Context
import com.example.timetonictest.login.dataAccess.LoginService
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class LoginRemoteDataSource @Inject constructor(
    private val loginService: LoginService,
) {

    suspend fun createAppKey() = loginService.createAppKey()

    suspend fun createOAuthKey(
        login: String, password: String, appKey: String,
    ) = loginService.createOAuthKey(login = login, password = password, appkey = appKey)

    suspend fun createSessKey(
        oAuthKey: String,
    ) = loginService.createSessKey(oAuthKey = oAuthKey)
}