package com.example.timetonictest.login.domain.model

data class OAuthKey(
    val createdVNB: String,
    val id: String,
    val oauthUser: String,
    val oauthkey: String,
    val req: String,
    val status: String,
)