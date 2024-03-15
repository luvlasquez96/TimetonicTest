package com.example.timetonictest.login

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.timetonictest.login.presentation.composables.LoginContent

@Composable
fun LoginScreenUI(navController: NavHostController) {
    LoginContent(navController)
}