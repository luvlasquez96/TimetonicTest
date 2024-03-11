package com.example.timetonictest.model

data class LoginResponse(
    val status: String,
    val errorCode: String,
    val errorMsg: String,
    val oauthKey: String
)
