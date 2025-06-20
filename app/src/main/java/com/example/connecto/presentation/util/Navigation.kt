package com.example.connecto.presentation.util

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.connecto.domain.models.Post
import com.example.connecto.presentation.activity.ActivityScreen
import com.example.connecto.presentation.chat.ChatScreen
import com.example.connecto.presentation.create_post.CreatePostScreen
import com.example.connecto.presentation.edit_profile.EditProfileScreen
import com.example.connecto.presentation.login.LoginScreen
import com.example.connecto.presentation.main_feed.MainFeedScreen
import com.example.connecto.presentation.post_detail.PostDetailScreen
import com.example.connecto.presentation.profile.ProfileScreen
import com.example.connecto.presentation.register.RegisterScreen
import com.example.connecto.presentation.search.SearchScreen
import com.example.connecto.presentation.splash.SplashScreen

@Composable
fun Navigation(
    navController: NavHostController
) {
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
        composable(Screen.ChatScreen.route) {
            ChatScreen(navController = navController)
        }
        composable(Screen.CreatePostScreen.route) {
            CreatePostScreen(navController = navController)
        }
        composable(Screen.ActivityScreen.route) {
            ActivityScreen(navController = navController)
        }
        composable(Screen.ProfileScreen.route) {
            ProfileScreen(navController = navController)
        }
        composable(Screen.EditProfileScreen.route) {
            EditProfileScreen(navController = navController)
        }
        composable(Screen.SearchScreen.route) {
            SearchScreen(navController = navController)
        }
        composable(Screen.PostDetailScreen.route) {
            PostDetailScreen(
                navController = navController,
                Post(
                    userName = "Cristiano Ronaldo",
                    imageUrl = "",
                    profileUrl = "",
                    description = "Greatness isn't luck — it's relentless hard work and discipline. " +
                            "Cristiano Ronaldo continues to inspire millions with every move. " +
                            "Greatness isn't luck — it's relentless hard work and discipline. " +
                            "Cristiano Ronaldo continues to inspire millions with every move.",
                    likeCount = 17,
                    commentCount = 10
                )
            )
        }
    }
}