package com.example.timetonictest.login.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.timetonictest.login.data.dataAccess.LoginRepository
import com.example.timetonictest.login.domain.model.AppKey
import com.example.timetonictest.login.domain.model.OAuthKey
import com.example.timetonictest.login.domain.model.SessionKey
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.async
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class LoginViewModel @Inject constructor(private val loginRepository: LoginRepository) :
    ViewModel() {

    private var _viewState = MutableStateFlow<ViewState>(ViewState.Loading)
    val viewState = _viewState.asStateFlow()

    private var _viewEvent = MutableSharedFlow<ViewEvent>(
        1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )
    val viewEvent: Flow<ViewEvent> = _viewEvent

    fun loginUser(login: String, password: String) {
        val createAppKey = viewModelScope.async {
            createAppKey().getOrThrow()
        }
        val createOAuthKey = viewModelScope.async {
            createOAuthKey(login, password, createAppKey.await().appkey).getOrThrow()
        }
        viewModelScope.launch {
            val oAuthKey = createOAuthKey.await()
            createSessionKey(oAuthKey.oauthkey, oAuthKey.oauthUser).onSuccess {
                loginRepository.saveSessionKey(it.sesskey)
                _viewState.value = ViewState.Loaded(oAuthKey.oauthUser)
            }.onFailure {
                _viewState.value = ViewState.Error(it.message.toString())
            }
        }
    }

    suspend fun createAppKey(): Result<AppKey> {
        return loginRepository.createAppKey()
    }

    private suspend fun createOAuthKey(
        login: String,
        password: String,
        appkey: String,
    ): Result<OAuthKey> {
        return loginRepository.createOAuthKey(login, password, appkey)
    }

    private suspend fun createSessionKey(oAuthKey: String, oAuthUser: String): Result<SessionKey> {
        return loginRepository.createSessionKey(oAuthKey, oAuthUser)
    }


    sealed class ViewState {
        object Loading : ViewState()
        data class Error(val errorMessage: String) : ViewState()
        data class Loaded (val user: String): ViewState()
    }


    sealed class ViewEvent {}
}