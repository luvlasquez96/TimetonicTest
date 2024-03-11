package com.example.timetonictest.navigation.screen.home

sealed class HomeScreen (val route: String) {
    object Home : HomeScreen("home")
}