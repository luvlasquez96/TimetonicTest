package com.example.timetonictest.login.remote.model

data class CreateAppKey(
    val appkey: String,
    val createdVNB: String,
    val id: String,
    val req: String,
    val status: String
)