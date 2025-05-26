package com.example.connecto.presentation.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
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
import com.example.connecto.domain.models.User
import com.example.connecto.presentation.components.Post
import com.example.connecto.presentation.components.StandardToolBar
import com.example.connecto.presentation.profile.components.BannerSection
import com.example.connecto.presentation.profile.components.ProfileHeaderSection
import com.example.connecto.presentation.profile.components.ProfileState
import com.example.connecto.presentation.ui.theme.profilePictureSizeLarge
import com.example.connecto.presentation.ui.theme.spaceMedium
import com.example.connecto.presentation.util.Screen

@Composable
fun ProfileScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
    ) {
        StandardToolBar(
            modifier = Modifier.fillMaxWidth(),
            navController = navController,
            showArrowBack = false,
            navActions = {
                IconButton(
                    onClick = {}
                ) {
                    Icon(
                        imageVector = Icons.Default.MoreVert,
                        contentDescription = stringResource(id = R.string.more_option)
                    )
                }
            },
            title = {
                Text(
                    text = stringResource(id = R.string.profile),
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground
                )
            },
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
        ) {
            item {
                BannerSection(
                    modifier = Modifier
                        .aspectRatio(2.5f),
                )
            }
            item {
                ProfileHeaderSection(
                    user = User(
                        profilePictureUrl = "",
                        userName = "Cristiano Ronaldo",
                        description = "Greatness isn't luck — it's relentless hard work and discipline." +
                                "Cristiano Ronaldo continues to inspire millions with every move.",
                        followersCount = 250,
                        followingCount = 200,
                        postCount = 50
                    )
                )
            }
            items(20) {
                Spacer(
                    modifier = Modifier
                        .height(spaceMedium)
                        .offset(y = -profilePictureSizeLarge / 2f)
                )
                Post(
                    post = com.example.connecto.domain.models.Post(
                        userName = "Cristiano Ronaldo",
                        imageUrl = "",
                        profileUrl = "",
                        description = "Greatness isn't luck — it's relentless hard work and discipline. " +
                                "Cristiano Ronaldo continues to inspire millions with every move.",
                        likeCount = 17,
                        commentCount = 10,
                    ),
                    showProfilePicture = false,
                    onPostClick = {
                        navController.navigate(Screen.PostDetailScreen.route)
                    },
                    modifier = Modifier
                        .offset(y = -profilePictureSizeLarge / 2f)
                )
            }
        }
    }
}