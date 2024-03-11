package com.example.timetonictest.navigation.graph.auth

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.timetonictest.login.LoginScreenUI
import com.example.timetonictest.navigation.screen.Graph
import com.example.timetonictest.navigation.screen.auth.AuthScreen

fun NavGraphBuilder.AuthNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.AUTH,
        startDestination = AuthScreen.Login.route
    ) {
       composable(route = AuthScreen.Login.route) {
           LoginScreenUI(navController = navController)
       }
    }
}