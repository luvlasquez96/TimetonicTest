package com.example.timetonictest.login.data.dataAccess

import com.example.timetonictest.login.data.local.LocalDataSource
import com.example.timetonictest.login.data.remote.LoginMapper
import com.example.timetonictest.login.data.remote.LoginRemoteDataSource
import com.example.timetonictest.login.domain.model.AppKey
import com.example.timetonictest.login.domain.model.OAuthKey
import com.example.timetonictest.login.domain.model.SessionKey
import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val loginRemoteDataSource: LoginRemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val loginMapper: LoginMapper,
) {

    suspend fun createAppKey(): Result<AppKey> {
        val result = loginRemoteDataSource.createAppKey()
        return when (result.body()!!.status == "ok") {
            true -> Result.success(loginMapper.transformCreateAppKeyToAppKey(result.body()!!))
            false -> throw Exception(result.errorBody().toString())
        }
    }

    suspend fun createOAuthKey(
        login: String, password: String, appKey: String,
    ): Result<OAuthKey> {
        val result = loginRemoteDataSource.createOAuthKey(login, password, appKey)
        return when (result.body()!!.status == "ok") {
            true -> Result.success(loginMapper.transformCreateOAuthKeyToOAuthKey(result.body()!!))
            false -> throw Exception(result.errorBody().toString())
        }
    }

    suspend fun createSessionKey(
        oAuthKey: String,
        oAuthUser: String,
    ): Result<SessionKey> {
        val result = loginRemoteDataSource.createSessKey(oAuthKey, oAuthUser)
        return when (result.body()!!.status == "ok") {
            true -> Result.success(loginMapper.transformCreateSessionKeyToSessionKey(result.body()!!))
            false -> throw Exception(result.errorBody().toString())
        }
    }

    fun saveSessionKey(sessionKey: String) {
        localDataSource.saveSessionKey(sessionKey)
    }

    fun getSessionKey(): String = localDataSource.getSessionKey()
}