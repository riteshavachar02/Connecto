package com.example.connecto.presentation.post_detail

import DarkGray
import MediumGray
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.connecto.R
import com.example.connecto.domain.models.Comment
import com.example.connecto.domain.models.Post
import com.example.connecto.presentation.components.ActionBar
import com.example.connecto.presentation.components.StandardToolBar
import com.example.connecto.presentation.ui.theme.ProfilePictureSizeSmall
import com.example.connecto.presentation.ui.theme.SpaceLarge
import com.example.connecto.presentation.ui.theme.SpaceMedium
import com.example.connecto.presentation.ui.theme.SpaceSmall

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
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.surface)
        ) {
            item {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
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
                                    .padding(SpaceLarge)
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
                                    onUserNameClick = { username ->

                                    }
                                )
                                Spacer(modifier = Modifier.height(SpaceSmall))
                                Text(
                                    text = post.description,
                                    style = MaterialTheme.typography.bodyMedium,
                                )
                                Spacer(modifier = Modifier.height(SpaceMedium))
                                Text(
                                    text = stringResource(
                                        R.string.liked_by_x_people,
                                        post.likeCount
                                    ),
                                    style = MaterialTheme.typography.bodyMedium
                                )
                            }
                        }
                    }

                }
            }
            items(20) {
                Comment(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = SpaceMedium,
                            vertical = SpaceSmall
                        ),
                    comment = Comment(
                        userName = "Cristiano Ronaldo$it",
                        comment = "Greatness isn't luck — it's relentless hard work and discipline." +
                                "Cristiano Ronaldo continues to inspire millions with every move." +
                                "Greatness isn't luck — it's relentless hard work and discipline." +
                                "Cristiano Ronaldo continues to inspire millions with every move,"
                    )
                )
            }
        }
    }
}

@Composable
fun Comment(
    modifier: Modifier = Modifier,
    comment: Comment = Comment(),
    onLikedClicked: (Boolean) -> Unit = {}
) {
    Card(
        modifier = modifier,
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background,
            contentColor = MaterialTheme.colorScheme.onBackground
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(SpaceMedium)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ronaldo_profile),
                        contentDescription = "Profile picture",
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(ProfilePictureSizeSmall)
                    )
                    Spacer(modifier = Modifier.width(SpaceSmall))
                    Text(
                        text = comment.userName,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }
                Text(
                    text = "2 days ago",
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center
                )
            }
            Spacer(modifier = Modifier.height(SpaceMedium))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = comment.comment,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.weight(9f)
                )
                Spacer(modifier = Modifier.width(SpaceSmall))
                IconButton(
                    onClick = {
                        onLikedClicked(comment.isLiked)
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = if (comment.isLiked) {
                            stringResource(id = R.string.unlike)
                        } else stringResource(id = R.string.like)
                    )
                }
            }
            Spacer(modifier = Modifier.height(SpaceMedium))
            Text(
                text = stringResource(id = R.string.liked_by_x_people, comment.likeCount),
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}