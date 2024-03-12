package com.example.timetonictest.login.remote

import com.example.timetonictest.login.domain.model.AppKey
import com.example.timetonictest.login.domain.model.OAuthKey
import com.example.timetonictest.login.domain.model.SessionKey
import com.example.timetonictest.login.remote.model.CreateAppKey
import com.example.timetonictest.login.remote.model.CreateOAuthKey
import com.example.timetonictest.login.remote.model.CreateSessionKey
import javax.inject.Inject

class LoginMapper @Inject constructor() {

    fun transformCreateAppKeyToAppKey(createAppKey: CreateAppKey): AppKey =
        AppKey(
            appkey = createAppKey.appkey,
            createdVNB = createAppKey.createdVNB,
            id = createAppKey.id,
            req = createAppKey.req,
            status = createAppKey.status
        )
    fun transformCreateOAuthKeyToOAuthKey(createOAuthKey: CreateOAuthKey): OAuthKey =
        OAuthKey(
            createdVNB = createOAuthKey.createdVNB,
            id = createOAuthKey.id,
            oauthUser = createOAuthKey.oauthUser,
            oauthkey = createOAuthKey.oauthkey,
            req = createOAuthKey.req,
            status = createOAuthKey.status
        )
    fun transformCreateSessionKeyToSessionKey(createSessionKey: CreateSessionKey): SessionKey =
        SessionKey(
            appName = createSessionKey.appName,
            createdVNB = createSessionKey.createdVNB,
            id = createSessionKey.id,
            req = createSessionKey.req,
            sesskey = createSessionKey.sesskey,
            status = createSessionKey.status
        )

}