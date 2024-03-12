package com.example.timetonictest.login.remote

import com.example.timetonictest.login.domain.model.AppKey
import com.example.timetonictest.login.domain.model.OAuthKey
import com.example.timetonictest.login.domain.model.SessKey
import com.example.timetonictest.login.remote.model.CreateAppKey
import com.example.timetonictest.login.remote.model.CreateOAuthKey
import com.example.timetonictest.login.remote.model.CreateSessKey
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
    fun transformCreateSessKeyToSessKey(createSessKey: CreateSessKey): SessKey =
        SessKey(
            appName = createSessKey.appName,
            createdVNB = createSessKey.createdVNB,
            id = createSessKey.id,
            req = createSessKey.req,
            sesskey = createSessKey.sesskey,
            status = createSessKey.status
        )

}