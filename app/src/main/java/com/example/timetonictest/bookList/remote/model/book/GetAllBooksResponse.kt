package com.example.timetonictest.bookList.remote.model.book

import com.google.gson.annotations.SerializedName

data class GetAllBooksResponse(
    @SerializedName("allBooks")val allBooksResponse: AllBooksResponse,
    val createdVNB: String,
    val req: String,
    val sstamp: Long,
    val status: String
)