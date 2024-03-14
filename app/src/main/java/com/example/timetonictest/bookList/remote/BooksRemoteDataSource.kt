package com.example.timetonictest.bookList.remote

import com.example.timetonictest.bookList.data.dataAccess.BooksService
import javax.inject.Inject

class BooksRemoteDataSource @Inject constructor(private val booksService: BooksService) {
    suspend fun getBooks(oAuthUser: String, user: String, sessionKey: String) =
        booksService.listOfBooks(oAuthUser = oAuthUser, user = user, sessionKey = sessionKey)
}
