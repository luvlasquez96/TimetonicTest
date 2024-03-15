package com.example.timetonictest.login.dataAccess

import com.example.timetonictest.login.data.dataAccess.LoginRepository
import com.example.timetonictest.login.domain.model.AppKey
import com.example.timetonictest.login.data.local.LocalDataSource
import com.example.timetonictest.login.data.remote.LoginMapper
import com.example.timetonictest.login.data.remote.LoginRemoteDataSource
import com.example.timetonictest.login.data.remote.model.CreateAppKeyResponse
import com.example.timetonictest.login.data.remote.model.CreateOAuthKeyResponse
import com.example.timetonictest.login.data.remote.model.CreateSessionKeyResponse
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import retrofit2.Response

@OptIn(ExperimentalCoroutinesApi::class)
class LoginRepositoryTest {
    @MockK
    private lateinit var loginRemoteDataSource: LoginRemoteDataSource

    @MockK
    private lateinit var loginMapper: LoginMapper

    @MockK
    private lateinit var localDataSource: LocalDataSource

    @InjectMockKs
    private lateinit var loginRepository: LoginRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        loginRepository = LoginRepository(
            loginRemoteDataSource,
            localDataSource,
            loginMapper
        )
    }

    @Test
    fun `Given createAppKey data WHEN createAppKey is called THEN retrun AppKey`() {
        runTest {
            coEvery {
                loginRemoteDataSource.createAppKey()
            } returns Response.success(createAppKeyResponse)
            coEvery {
                loginMapper.transformCreateAppKeyToAppKey(createAppKeyResponse)
            } returns AppKey(
                "Q37l-uVRc-6mDC-bCtW-VUF5-x6kY-TzYY",
                "live-6.49q/6.49",
                "961896",
                "createAppKey",
                "ok"
            )
            val result = loginRepository.createAppKey()
            assert(result.isSuccess)
            assert(
                result.getOrNull() == AppKey(
                    "Q37l-uVRc-6mDC-bCtW-VUF5-x6kY-TzYY",
                    "live-6.49q/6.49",
                    "961896",
                    "createAppKey",
                    "ok"
                )
            )
        }
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