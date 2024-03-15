package com.example.timetonictest.bookList.presentation.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.timetonictest.bookList.domain.Book
import com.example.timetonictest.bookList.presentation.BooksViewModel

@Composable
fun BookListContent(oAuthUser: String) {
    val bookList = remember { mutableStateOf(listOf<Book>()) }
    val booksViewModel: BooksViewModel = hiltViewModel()
    val viewState by booksViewModel.viewState.collectAsState()

    LaunchedEffect("books"){
        booksViewModel.getBooks(oAuthUser = oAuthUser, user = oAuthUser)
    }

    LaunchedEffect(viewState) {
        when (viewState) {
            is BooksViewModel.ViewState.Loaded -> {
                bookList.value = (viewState as BooksViewModel.ViewState.Loaded).bookList
            }

            is BooksViewModel.ViewState.Error -> {}

            is BooksViewModel.ViewState.Loading -> {
            }

        }
    }
    Column {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            items(bookList.value.size) {
                val coverImage = (bookList.value[it].ownerPrefs?.oCoverImg)?.replace("/dev/","https://timetonic.com/live/")
                BookListItem(
                    image = coverImage?: "",
                    title = bookList.value[it].ownerPrefs?.title ?: ""
                )
                Divider()
            }
        }
    }
}

@Composable
fun BookListItem(image: String, title: String) {
    val context = LocalContext.current
    Column(modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 8.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyMedium,
                overflow = TextOverflow.Ellipsis,
                fontSize = 16.sp,
            )
            AsyncImage(
                modifier = Modifier
                    .size(90.dp),
                model = ImageRequest.Builder(context)
                    .data(image)
                    .crossfade(true)
                    .build(),
                contentScale = ContentScale.Fit,
                contentDescription = ""
            )
        }
    }
}