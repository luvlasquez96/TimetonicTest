package com.example.timetonictest.login.data.remote

import com.example.timetonictest.login.domain.model.AppKey
import com.example.timetonictest.login.domain.model.OAuthKey
import com.example.timetonictest.login.domain.model.SessionKey
import com.example.timetonictest.login.data.remote.model.CreateAppKeyResponse
import com.example.timetonictest.login.data.remote.model.CreateOAuthKeyResponse
import com.example.timetonictest.login.data.remote.model.CreateSessionKeyResponse
import javax.inject.Inject

class LoginMapper @Inject constructor() {

    fun transformCreateAppKeyToAppKey(createAppKeyResponse: CreateAppKeyResponse): AppKey =
        AppKey(
            appkey = createAppKeyResponse.appkey,
            createdVNB = createAppKeyResponse.createdVNB,
            id = createAppKeyResponse.id,
            req = createAppKeyResponse.req,
            status = createAppKeyResponse.status
        )
    fun transformCreateOAuthKeyToOAuthKey(createOAuthKeyResponse: CreateOAuthKeyResponse): OAuthKey =
        OAuthKey(
            createdVNB = createOAuthKeyResponse.createdVNB,
            id = createOAuthKeyResponse.id,
            oauthUser = createOAuthKeyResponse.oauthUser,
            oauthkey = createOAuthKeyResponse.oauthkey,
            req = createOAuthKeyResponse.req,
            status = createOAuthKeyResponse.status
        )
    fun transformCreateSessionKeyToSessionKey(createSessionKeyResponse: CreateSessionKeyResponse): SessionKey =
        SessionKey(
            appName = createSessionKeyResponse.appName,
            createdVNB = createSessionKeyResponse.createdVNB,
            id = createSessionKeyResponse.id,
            req = createSessionKeyResponse.req,
            sesskey = createSessionKeyResponse.sesskey,
            status = createSessionKeyResponse.status
        )

}