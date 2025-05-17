package com.example.connecto.presentation.util

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.connecto.presentation.main_feed.MainFeedScreen
import com.example.connecto.presentation.login.LoginScreen
import com.example.connecto.presentation.register.RegisterScreen
import com.example.connecto.presentation.splash.SplashScreen

@Composable
fun Navigation () {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route
    ) {
        composable(Screen.SplashScreen.route) {
            SplashScreen(navController = navController)
        }
        composable(Screen.LoginScreen.route) {
            LoginScreen(navController = navController)
        }
        composable(Screen.RegisterScreen.route) {
            RegisterScreen(navController = navController)
        }
        composable(Screen.MainFeedScreen.route) {
            MainFeedScreen(navController = navController)
        }
    }
}