package com.example.timetonictest.bookList.remote.model.book

data class UserPrefs(
    val inGlobalSearch: Boolean,
    val inGlobalTasks: Boolean,
    val maxMsgsOffline: Int,
    val notificationEnabled: String,
    val notifyEmailCopy: Boolean,
    val notifyMobile: Boolean,
    val notifySmsCopy: Boolean,
    val notifyWhenMsgInArchivedBook: Boolean,
    val syncWithHubic: Boolean,
    val uCoverColor: String,
    val uCoverImg: String,
    val uCoverLetOwnerDecide: Boolean,
    val uCoverType: String,
    val uCoverUseLastImg: Boolean
)