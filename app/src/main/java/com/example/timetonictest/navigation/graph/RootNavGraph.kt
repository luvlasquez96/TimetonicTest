package com.example.timetonictest.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.timetonictest.navigation.graph.home.HomeNavGraph
import com.example.timetonictest.navigation.graph.auth.AuthNavGraph
import com.example.timetonictest.navigation.screen.Graph

@Composable
fun RootNavGraph(navController: NavHostController) {
    NavHost(navController = navController, route = Graph.ROOT, startDestination = Graph.AUTH) {
        AuthNavGraph(navController = navController)
        HomeNavGraph(navController = navController)
    }
}