package com.example.timetonictest.login.data.dataAccess

import com.example.timetonictest.login.data.remote.model.CreateAppKeyResponse
import com.example.timetonictest.login.data.remote.model.CreateOAuthKeyResponse
import com.example.timetonictest.login.data.remote.model.CreateSessionKeyResponse
import com.example.timetonictest.network.di.BASE_PATH
import retrofit2.Response
import retrofit2.http.POST
import retrofit2.http.Query

interface LoginService {
    @POST(BASE_PATH)
    suspend fun createAppKey(
        @Query("version") version: String = VERSION,
        @Query("req") req: String = APP_KEY,
        @Query("appname") appName: String = APP_NAME,
    ): Response<CreateAppKeyResponse>

    @POST(BASE_PATH)
    suspend fun createOAuthKey(
        @Query("req") req: String = CREATE_OAUTH_KEY,
        @Query("login") login: String,
        @Query("pwd") password: String,
        @Query("appkey") appkey: String,
    ): Response<CreateOAuthKeyResponse>

    @POST(BASE_PATH)
    suspend fun createSessKey(
        @Query("req") req: String = CREATE_SESSION_KEY,
        @Query("o_u") oAuthUser: String,
        @Query("oauthkey") oAuthKey: String,
        @Query("restrictions") restrictions: String = "",
    ): Response<CreateSessionKeyResponse>
}

const val APP_KEY = "createAppkey"
const val CREATE_OAUTH_KEY = "createOauthkey"
const val CREATE_SESSION_KEY = "createSesskey"
const val VERSION = "1.47"
const val APP_NAME = "android"