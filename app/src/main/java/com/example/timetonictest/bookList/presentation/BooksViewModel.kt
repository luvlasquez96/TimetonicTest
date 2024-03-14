package com.example.timetonictest.bookList.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.timetonictest.bookList.data.dataAccess.BooksRepository
import com.example.timetonictest.bookList.domain.Book
import com.example.timetonictest.login.data.dataAccess.LoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class BooksViewModel @Inject constructor(
    private val booksRepository: BooksRepository,
    private val loginRepository: LoginRepository,
) : ViewModel() {

    private var _viewState =
        MutableStateFlow<ViewState>(ViewState.Loading)
    val viewState = _viewState.asStateFlow()


    fun getBooks(oAuthKey: String, user: String) {
        viewModelScope.launch {
            val sessionKey = loginRepository.getSessionKey()
            if (sessionKey.isNotEmpty()) {
                booksRepository.getBooks(oAuthKey = oAuthKey, user = user, sessionKey = sessionKey)
                    .onSuccess { bookList ->
                        _viewState.value = ViewState.Loaded(bookList)
                    }.onFailure { throwable ->
                        _viewState.value = ViewState.Error(throwable.message.toString())
                    }
            } else {
                _viewState.value = ViewState.Error("Session key is empty")
            }
        }
    }


    sealed class ViewState {
        object Loading : ViewState()
        data class Error(val errorMessage: String) : ViewState()
        data class Loaded (val bookList: List<Book>) : ViewState()
    }
}