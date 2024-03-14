package com.example.timetonictest.bookList.remote.model.book

data class BooksResponse(
    val allBooksResponse: AllBooksResponse,
    val createdVNB: String,
    val req: String,
    val sstamp: Long,
    val status: String
)