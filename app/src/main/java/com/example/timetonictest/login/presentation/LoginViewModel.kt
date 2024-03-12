package com.example.timetonictest.login.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.timetonictest.login.dataAccess.LoginRepository
import com.example.timetonictest.login.domain.model.AppKey
import com.example.timetonictest.login.domain.model.OAuthKey
import com.example.timetonictest.login.domain.model.SessKey
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
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

    suspend fun loginUser(login: String, password: String) {
        viewModelScope.launch {
            createAppKey().onSuccess {appKey ->
                createOAuthKey(login, password, appKey.appkey).onSuccess {oAuthKey ->
                    createSessKey(oAuthKey.oauthkey).onSuccess {sessKey->
                        loginRepository.saveSessionKey(sessKey.sesskey)
                        _viewState.value = ViewState.Loaded
                    }.onFailure {
                        _viewState.value = ViewState.Error(it.message.toString())
                    }
                }
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

    private suspend fun createSessKey(oAuthUser: String): Result<SessKey> {
        return loginRepository.createSessKey(oAuthUser)
    }


    sealed class ViewState {
        object Loading : ViewState()
        data class Error(val errorMessage: String) : ViewState()
        object Loaded : ViewState()
    }


    sealed class ViewEvent {}
}