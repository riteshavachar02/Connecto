package com.example.connecto.presentation.main_feed

import MediumGray
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.connecto.presentation.components.Post

@Composable
fun MainFeedScreen(
    navController: NavController
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MediumGray)
    ) {
        item {
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
        item {
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
        item {
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
        item {
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
    }
}
