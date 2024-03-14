package com.example.timetonictest.bookList.data.dataAccess

import com.example.timetonictest.bookList.remote.model.book.AllBooksResponse
import com.example.timetonictest.network.di.BASE_URL
import retrofit2.Response
import retrofit2.http.POST
import retrofit2.http.Query

interface BooksService {
    @POST(BASE_URL)
    suspend fun listOfBooks(
        @Query("req") req: String = GET_ALL_BOOKS,
        @Query("o_u") oAuthUser: String,
        @Query("u_c") user: String,
        @Query("sesskey") sessionKey: String,
    ): Response<AllBooksResponse>
}

const val GET_ALL_BOOKS = "getallbooks"