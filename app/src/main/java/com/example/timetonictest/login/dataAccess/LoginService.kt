package com.example.timetonictest.login.dataAccess

import com.example.timetonictest.model.LoginResponse
import com.example.timetonictest.network.di.BASE_URL
import retrofit2.Response
import retrofit2.http.POST
import retrofit2.http.Query

interface LoginService {
    @POST(BASE_URL)
    suspend fun createAppKey(
        @Query("version") version: String = VERSION,
        @Query("req") req: String = APP_KEY,
        @Query("appname") appName: String = APP_NAME,
    ): Response<LoginResponse>
}

const val APP_KEY = "createAppKey"
const val CREATE_OAUTH_KEY = "createOauthkey"
const val CREATE_SESSION_KEY = "getOauthkey"
const val VERSION = "1.47"
const val APP_NAME = "android"