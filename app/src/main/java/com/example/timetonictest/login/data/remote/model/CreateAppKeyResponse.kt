package com.example.timetonictest.login.data.remote.model

data class CreateAppKeyResponse(
    val appkey: String,
    val createdVNB: String,
    val id: String,
    val req: String,
    val status: String
)