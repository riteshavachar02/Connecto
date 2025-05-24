package com.example.connecto.presentation.post_detail

import DarkGray
import MediumGray
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.connecto.R
import com.example.connecto.domain.models.Post
import com.example.connecto.presentation.components.ActionBar
import com.example.connecto.presentation.components.StandardToolBar
import com.example.connecto.presentation.ui.theme.profilePictureSize
import com.example.connecto.presentation.ui.theme.spaceExtraSmall
import com.example.connecto.presentation.ui.theme.spaceMedium
import com.example.connecto.presentation.ui.theme.spaceSmall

@Composable
fun PostDetailScreen(
    navController: NavController,
    post: Post
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MediumGray)
    ) {
        StandardToolBar(
            title = {
                Text(
                    text = stringResource(id = R.string.your_feed),
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground
                )
            },
            navController = navController,
            showArrowBack = true,
            modifier = Modifier.fillMaxWidth(),
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(5.dp)
                    .clip(MaterialTheme.shapes.medium)
                    .background(DarkGray)
            ) {
                Image(
                    painterResource(id = R.drawable.kermit),
                    contentDescription = "Post image",
                    modifier = Modifier.fillMaxWidth()
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(spaceMedium)
                ) {
                    ActionBar(
                        userName = "Cristiano Ronaldo",
                        modifier = Modifier.fillMaxWidth(),
                        onLikeClick = { isLiked ->

                        },
                        onCommentClick = {

                        },
                        onShareClick = {

                        },
                        onUserNameClick = {username ->

                        }
                    )
                    Spacer(modifier = Modifier.height(spaceSmall))
                    Text(
                        text = post.description,
                        style = MaterialTheme.typography.bodyMedium,
                    )
                    Spacer(modifier = Modifier.height(spaceMedium))
                    Text(
                        text = stringResource(
                                R.string.liked_by_x_people,
                                post.likeCount
                        ),
                        style = MaterialTheme.typography.headlineMedium.copy(
                                fontSize = 16.sp
                        )
                    )
                }
            }
        }
    }
}