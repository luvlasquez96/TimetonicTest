package com.example.timetonictest.bookList.remote

import com.example.timetonictest.bookList.domain.Book
import com.example.timetonictest.bookList.remote.model.book.AllBooksResponse
import javax.inject.Inject

class BooksMapper @Inject constructor() {

    fun transformAllBooksResponseToListOfBooks(allBooksResponse: AllBooksResponse): List<Book> =
        allBooksResponse.books.map { bookResponse ->
            with(bookResponse) {
                Book(
                    accepted = accepted,
                    archived = archived,
                    b_c = b_c,
                    b_o = b_o,
                    canDisableSync = canDisableSync,
                    cluster = cluster,
                    contactConfirmed = contactConfirmed,
                    contact_u_c = contact_u_c,
                    defaultTemplate = defaultTemplate,
                    del = del,
                    description = description,
                    favorite = favorite,
                    hideBookMembers = hideBookMembers,
                    hideMessage = hideMessage,
                    invited = invited,
                    isDownloadable = isDownloadable,
                    langs = langs,
                    lastMedia = lastMedia,
                    lastMsgRead = lastMsgRead,
                    nbMembers = nbMembers,
                    nbMsgs = nbMsgs,
                    nbNotRead = nbNotRead,
                    notificationAudio = notificationAudio,
                    notificationWeb = notificationWeb,
                    order = order,
                    ownerPrefs = ownerPrefs,
                    sbid = sbid,
                    showFpOnOpen = showFpOnOpen,
                    sstamp = sstamp,
                    tags = tags,
                    userPrefs = userPrefs,
                )
            }
        }
}

