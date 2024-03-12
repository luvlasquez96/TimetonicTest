package com.example.timetonictest.login.dataAccess

import com.example.timetonictest.login.domain.model.AppKey
import com.example.timetonictest.login.domain.model.OAuthKey
import com.example.timetonictest.login.domain.model.SessKey
import com.example.timetonictest.login.remote.LoginMapper
import com.example.timetonictest.login.remote.LoginRemoteDataSource
import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val loginRemoteDataSource: LoginRemoteDataSource,
    private val loginMapper: LoginMapper,
) {

    suspend fun createAppKey(): Result<AppKey> {
        val result = loginRemoteDataSource.createAppKey()
        return when (result.isSuccessful) {
            true -> Result.success(loginMapper.transformCreateAppKeyToAppKey(result.body()!!))
            false -> throw Exception(result.errorBody().toString())
        }
    }

    suspend fun createOAuthKey(
        login: String, password: String, appKey: String,
    ): Result<OAuthKey> {
        val result = loginRemoteDataSource.createOAuthKey(login, password, appKey)
        return when (result.isSuccessful) {
            true -> Result.success(loginMapper.transformCreateOAuthKeyToOAuthKey(result.body()!!))
            false -> throw Exception(result.errorBody().toString())
        }
    }

    suspend fun createSessKey(
        oAuthKey: String,
    ): Result<SessKey> {
        val result = loginRemoteDataSource.createSessKey(oAuthKey)
        return when (result.isSuccessful) {
            true -> Result.success(loginMapper.transformCreateSessKeyToSessKey(result.body()!!))
            false -> throw Exception(result.errorBody().toString())
        }
    }

    suspend fun saveSessionKey(sessionKey: String) {

    }
}