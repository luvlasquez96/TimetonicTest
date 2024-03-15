package com.example.timetonictest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.timetonictest.bookList.presentation.composable.BookListScreen
import com.example.timetonictest.login.presentation.composables.LoginContent
import com.example.timetonictest.navigation.Directions
import com.example.timetonictest.ui.theme.TimetonicTestTheme
import com.example.timetonictest.utils.Constants
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TimetonicTestTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Directions.Login.route()
                ) {
                    composable(Directions.Login.route()) {
                        LoginContent(navController = navController)
                    }
                    composable(Directions.Home.route(), arguments = listOf(
                        navArgument(Constants.OAUTHUSER) { type = NavType.StringType }
                    )
                    ) {
                        BookListScreen(
                            oAuthUser = it.arguments?.getString(Constants.OAUTHUSER) ?: "",
                        )
                    }
                }
            }
        }
    }
}