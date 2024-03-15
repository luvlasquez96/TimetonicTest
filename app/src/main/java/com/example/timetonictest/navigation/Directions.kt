package com.example.timetonictest.navigation

import com.example.timetonictest.utils.Constants

sealed class Directions {
    val timetonicPrefix = "timetonic"

    abstract fun route(): String

    object Login : Directions() {
        override fun route(): String = "$timetonicPrefix/LOGIN"
    }
    object Home : Directions() {
        override fun route(): String =
            "$timetonicPrefix/HOME/{${Constants.OAUTHUSER}}"

        fun navigate(oauthUser: String): String = "$timetonicPrefix/HOME/$oauthUser"
    }
}