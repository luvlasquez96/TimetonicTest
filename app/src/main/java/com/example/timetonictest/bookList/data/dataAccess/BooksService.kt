package com.example.timetonictest.bookList.data.dataAccess

import com.example.timetonictest.bookList.remote.model.book.AllBooksResponse
import com.example.timetonictest.bookList.remote.model.book.GetAllBooksResponse
import com.example.timetonictest.network.di.BASE_PATH
import com.example.timetonictest.network.di.BASE_URL
import retrofit2.Response
import retrofit2.http.POST
import retrofit2.http.Query

interface BooksService {
    @POST(BASE_PATH)
    suspend fun listOfBooks(
        @Query("req") req: String = GET_ALL_BOOKS,
        @Query("o_u") oAuthUser: String,
        @Query("u_c") user: String,
        @Query("sesskey") sessionKey: String,
    ): Response<GetAllBooksResponse>
}

const val GET_ALL_BOOKS = "getAllBooks"