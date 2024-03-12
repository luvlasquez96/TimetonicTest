package com.example.timetonictest.navigation.screen.auth

sealed class AuthScreen (val route: String) {
    object Login : AuthScreen("login")
}