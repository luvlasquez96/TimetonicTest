package com.example.timetonictest.login.data.remote.model

import com.google.gson.annotations.SerializedName

data class CreateOAuthKeyResponse(
    val createdVNB: String,
    val id: String,
    @SerializedName("o_u") val oauthUser: String,
    val oauthkey: String,
    val req: String,
    val status: String
)