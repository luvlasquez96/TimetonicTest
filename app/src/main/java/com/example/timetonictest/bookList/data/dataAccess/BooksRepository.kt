package com.example.timetonictest.bookList.data.dataAccess

import com.example.timetonictest.bookList.domain.Book
import com.example.timetonictest.bookList.remote.BooksMapper
import com.example.timetonictest.bookList.remote.BooksRemoteDataSource
import javax.inject.Inject

class BooksRepository @Inject constructor(
    private val booksRemoteDataSource: BooksRemoteDataSource,
    private val booksMapper: BooksMapper,
) {
    suspend fun getBooks(oAuthKey: String, user: String, sessionKey: String): Result<List<Book>> {
        val result = booksRemoteDataSource.getBooks(oAuthKey, user, sessionKey)
        return if (result.isSuccessful) {
            Result.success(booksMapper.transformAllBooksResponseToListOfBooks(result.body()!!))
        } else {
            throw Exception(result.errorBody().toString())
        }
    }
}