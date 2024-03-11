package com.example.timetonictest.remote.model.book

data class AllBooks(
    val books: List<Book>,
    val contacts: List<Contact>,
    val nbBooks: Int,
    val nbContacts: Int
)