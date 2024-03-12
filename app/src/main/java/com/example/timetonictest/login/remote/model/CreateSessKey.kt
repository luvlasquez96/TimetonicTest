package com.example.timetonictest.login.remote.model

data class CreateSessKey(
    val appName: String,
    val createdVNB: String,
    val id: String,
    val req: String,
    val sesskey: String,
    val status: String
)