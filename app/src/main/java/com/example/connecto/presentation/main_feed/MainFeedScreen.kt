package com.example.connecto.presentation.main_feed

import MediumGray
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.example.connecto.R
import com.example.connecto.presentation.components.Post
import com.example.connecto.presentation.components.StandardToolBar
import com.example.connecto.presentation.util.Screen

@Composable
fun MainFeedScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MediumGray)
    ) {
        StandardToolBar(
            navController = navController,
            title = {
                Text(
                    text = stringResource(id = R.string.connecto),
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground
                )
            },
            modifier = Modifier.fillMaxWidth(),
            navActions = {
                IconButton(onClick = {
                    navController.navigate(Screen.SearchScreen.route)
                }) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "",
                        tint = MaterialTheme.colorScheme.onBackground
                    )
                }
            }
        )
        LazyColumn(
            modifier = Modifier.fillMaxSize()
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
}
