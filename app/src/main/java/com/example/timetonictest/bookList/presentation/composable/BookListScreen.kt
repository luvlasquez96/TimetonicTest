package com.example.timetonictest.bookList.presentation.composable

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.timetonictest.bookList.presentation.composable.BookListContent

@Composable
fun BookListScreen(oAuthUser: String) {
    BookListContent(oAuthUser = oAuthUser)
}