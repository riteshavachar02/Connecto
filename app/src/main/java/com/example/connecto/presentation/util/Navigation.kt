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
import com.example.connecto.presentation.main_feed.PersonListScreen
import com.example.connecto.presentation.register.RegisterScreen
import com.example.connecto.presentation.search.SearchScreen
import com.example.connecto.presentation.splash.SplashScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route
    ) {
        // Splash & Auth
        composable(Screen.SplashScreen.route) {
            SplashScreen(navController)
        }
        composable(Screen.LoginScreen.route) {
            LoginScreen(navController)
        }
        composable(Screen.RegisterScreen.route) {
            RegisterScreen(navController)
        }

        // Main App Screens
        composable(Screen.MainFeedScreen.route) {
            MainFeedScreen(navController)
        }
        composable(Screen.ChatScreen.route) {
            ChatScreen(navController)
        }
        composable(Screen.CreatePostScreen.route) {
            CreatePostScreen(navController)
        }
        composable(Screen.ActivityScreen.route) {
            ActivityScreen(navController)
        }
        composable(Screen.ProfileScreen.route) {
            ProfileScreen(navController)
        }

        // Profile Utilities
        composable(Screen.EditProfileScreen.route) {
            EditProfileScreen(navController)
        }
        composable(Screen.SearchScreen.route) {
            SearchScreen(navController)
        }
        composable(Screen.PersonListScreen.route) {
            PersonListScreen(navController)
        }

        // Static Post Detail Screen (for now)
        composable(Screen.PostDetailScreen.route) {
            PostDetailScreen(
                navController = navController,
                post = Post(
                    userName = "Cristiano Ronaldo",
                    imageUrl = "",
                    profileUrl = "",
                    description = "Greatness isn't luck — it's relentless hard work and discipline. " +
                            "Cristiano Ronaldo continues to inspire millions with every move.",
                    likeCount = 17,
                    commentCount = 10
                )
            )
        }
    }
}
