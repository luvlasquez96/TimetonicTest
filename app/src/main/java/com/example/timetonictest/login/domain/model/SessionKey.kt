package com.example.timetonictest.login.domain.model

data class SessionKey(
    val appName: String,
    val createdVNB: String,
    val id: String,
    val req: String,
    val sesskey: String,
    val status: String,
)