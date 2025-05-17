package com.example.connecto.presentation.main_feed

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.connecto.presentation.components.Post

@Composable
fun MainFeedScreen(
    navController: NavController
) {

    Post(
        post = com.example.connecto.domain.models.Post(
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