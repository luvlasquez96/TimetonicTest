package com.example.timetonictest.remote.model.book

data class BooksResponse(
    val allBooks: AllBooks,
    val createdVNB: String,
    val req: String,
    val sstamp: Long,
    val status: String
)