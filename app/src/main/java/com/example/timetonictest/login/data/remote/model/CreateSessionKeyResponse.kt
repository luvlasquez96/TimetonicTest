package com.example.timetonictest.login.data.remote.model

data class CreateSessionKeyResponse(
    val appName: String,
    val createdVNB: String,
    val id: String,
    val req: String,
    val sesskey: String,
    val status: String
)