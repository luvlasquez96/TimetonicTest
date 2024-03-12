package com.example.timetonictest.login.dataAccess

import com.example.timetonictest.login.remote.model.CreateAppKey
import com.example.timetonictest.login.remote.model.CreateOAuthKey
import com.example.timetonictest.login.remote.model.CreateSessKey
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
    ): Response<CreateAppKey>

    @POST(BASE_URL)
    suspend fun createOAuthKey(
        @Query("req") req: String = CREATE_OAUTH_KEY,
        @Query("login") login: String,
        @Query("pwd") password: String,
        @Query("appkey") appkey: String,
    ): Response<CreateOAuthKey>

    @POST(BASE_URL)
    suspend fun createSessKey(
        @Query("req") req: String = CREATE_SESSION_KEY,
        @Query("o_u") oAuthUser: String = OAUTH_USER,
        @Query("oauthkey") oAuthKey: String,
        @Query("restrictions") restrictions: String = "",
    ): Response<CreateSessKey>


}

const val APP_KEY = "createAppKey"
const val CREATE_OAUTH_KEY = "createOauthkey"
const val CREATE_SESSION_KEY = "createSesskey"
const val VERSION = "1.47"
const val APP_NAME = "android"
const val OAUTH_USER = "demo"