package com.example.timetonictest.remote.model.book

data class Media(
    val del: Boolean,
    val emailCid: String,
    val ext: String,
    val id: Int,
    val internName: String,
    val originName: String,
    val size: Int,
    val type: String,
    val uuid: String
)