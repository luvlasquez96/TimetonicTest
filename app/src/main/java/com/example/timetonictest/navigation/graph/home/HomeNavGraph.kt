package com.example.timetonictest.navigation.graph.home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.timetonictest.bookList.BookListScreen
import com.example.timetonictest.navigation.screen.home.HomeScreen
import com.example.timetonictest.navigation.screen.Graph

fun NavGraphBuilder.HomeNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.HOME,
        startDestination = HomeScreen.Home.route
    ) {
        composable(route = HomeScreen.Home.route) {
            BookListScreen(navController)
        }
    }
}