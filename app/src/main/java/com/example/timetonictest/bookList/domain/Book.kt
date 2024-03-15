package com.example.timetonictest.bookList.domain

import com.example.timetonictest.bookList.remote.model.book.OwnerPrefs
import com.example.timetonictest.bookList.remote.model.book.UserPrefs
import com.google.gson.annotations.SerializedName

data class Book(
    val accepted: Boolean?,
    val archived: Boolean?,
    val b_c: String?,
    val b_o: String?,
    val canDisableSync: Boolean?,
    val cluster: String?,
    val contactConfirmed: Boolean?,
    val contact_u_c: String?,
    val defaultTemplate: String?,
    val del: Boolean?,
    val description: Any?,
    val favorite: Boolean?,
    val hideBookMembers: String?,
    val hideMessage: String?,
    val invited: Boolean?,
    val isDownloadable: Boolean?,
    val langs: Any?,
    val lastMedia: Int?,
    val lastMsgRead: Int?,
    val nbMembers: Int?,
    val nbMsgs: Int?,
    val nbNotRead: Int?,
    val notificationAudio: String?,
    val notificationWeb: String?,
    val order: Int?,
    val ownerPrefs: OwnerPrefs?,
    val sbid: Int?,
    val showFpOnOpen: Boolean?,
    val sstamp: Long?,
    val tags: Any?,
    val userPrefs: UserPrefs?
)
