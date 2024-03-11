package com.example.timetonictest.remote.model.authKey

data class AuthKeyResponse(
    val createdVNB: String,
    val id: String,
    val o_u: String,
    val oauthkey: String,
    val req: String,
    val status: String
)