package com.example.timetonictest.bookList.remote.model.book

data class AllBooksResponse(
    val books: List<BookResponse>,
    val nbBooks: Int,
    val nbContacts: Int
)