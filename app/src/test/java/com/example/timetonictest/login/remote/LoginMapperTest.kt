package com.example.timetonictest.login.remote

import com.example.timetonictest.login.data.remote.LoginMapper
import com.example.timetonictest.login.data.remote.model.CreateAppKeyResponse
import com.example.timetonictest.login.data.remote.model.CreateOAuthKeyResponse
import com.example.timetonictest.login.data.remote.model.CreateSessionKeyResponse
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test

class LoginMapperTest {

    private lateinit var loginMapper: LoginMapper

    @Before
    fun setUp() {
        loginMapper = LoginMapper()
    }

    @Test
    fun `Given createAppKey response WHEN transformCreateAppKeyToAppKey is called THEN return AppKey`() {
        val result = loginMapper.transformCreateAppKeyToAppKey(createAppKeyResponse)
        assertEquals(result.appkey, "Q37l-uVRc-6mDC-bCtW-VUF5-x6kY-TzYY")
        assertEquals(result.createdVNB, "live-6.49q/6.49")
    }

    @Test
    fun `Given CreateOAuthKey response WHEN transformCreateAppKeyToAppKey is called THEN return OAuthKey`() {
        val result = loginMapper.transformCreateOAuthKeyToOAuthKey(createOAuthKeyResponse)
        assertEquals(result.oauthkey, "hy1Y-d1jS-XjEc-rJRc-U1AC-zB4D-e8q5")
    }

    @Test
    fun `Given CreateSessionKey response WHEN transformCreateAppKeyToAppKey is called THEN return SessionKey`() {
        val result = loginMapper.transformCreateSessionKeyToSessionKey(createSessionKeyResponse)
        assertEquals(result.sesskey, "3pYu-jdzT-abCk-BKjJ-j2eb-yiSa-TDAk")
    }

    companion object {
        val createAppKeyResponse = CreateAppKeyResponse(
            "Q37l-uVRc-6mDC-bCtW-VUF5-x6kY-TzYY",
            "live-6.49q/6.49",
            "961896",
            "createAppKey",
            "ok"
        )
        val createOAuthKeyResponse = CreateOAuthKeyResponse(
            "live-6.49q/6.49",
            "961896",
            "demo",
            "hy1Y-d1jS-XjEc-rJRc-U1AC-zB4D-e8q5",
            "createOauthkey",
            "ok"
        )
        val createSessionKeyResponse = CreateSessionKeyResponse(
            "api",
            "live-6.49q/6.49",
            "961896",
            "createSessionkey",
            "3pYu-jdzT-abCk-BKjJ-j2eb-yiSa-TDAk",
            "ok"
        )
    }
}