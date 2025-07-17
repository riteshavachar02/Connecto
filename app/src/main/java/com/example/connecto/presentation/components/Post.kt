package com.example.connecto.presentation.components

import DarkGray
import HintGray
import TextWhite
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.connecto.R
import com.example.connecto.domain.models.Post
import com.example.connecto.presentation.ui.theme.IconSizeMedium
import com.example.connecto.presentation.ui.theme.ProfilePictureExtraSizeSmall
import com.example.connecto.presentation.ui.theme.SpaceExtraSmall
import com.example.connecto.presentation.ui.theme.SpaceMedium
import com.example.connecto.presentation.ui.theme.SpaceSmall
import com.example.connecto.utils.Constants


@Composable
fun Post(
    post: Post,
    modifier: Modifier = Modifier,
    showProfilePicture: Boolean = true,
    onPostClick: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = SpaceSmall,
                end = SpaceSmall,
                top = SpaceExtraSmall
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(MaterialTheme.shapes.medium)
                .shadow(5.dp)
                .background(DarkGray)
                .clickable {
                    onPostClick()
                }
        ) {
            Image(
                painterResource(id = R.drawable.kermit),
                contentDescription = "Post image",
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(SpaceSmall)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    if (showProfilePicture) {
                        Image(
                            painterResource(id = R.drawable.ronaldo_profile),
                            contentDescription = "Profile picture",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(ProfilePictureExtraSizeSmall)
                                .clip(CircleShape)
                                .border(
                                    width =  1.dp,
                                    color =  MaterialTheme.colorScheme.onSurfaceVariant,
                                    shape =  CircleShape
                                )
                        )
                    }
                    Spacer(modifier = Modifier.width(SpaceSmall))
                    ActionBar(
                        userName = "Cristiano Ronaldo",
                        modifier = Modifier.fillMaxWidth(),
                        showProfilePicture = showProfilePicture,
                        onLikeClick = { isLiked ->

                        },
                        onCommentClick = {

                        },
                        onShareClick = {

                        },
                        onUserNameClick = {username ->

                        }
                    )
                }
                Spacer(modifier = Modifier.height(SpaceSmall))
                Text(
                    text = buildAnnotatedString {
                        append(post.description)
                        withStyle(SpanStyle(
                            color = HintGray
                        )) {
                            append(
                                LocalContext.current.getString(
                                    R.string.read_more
                                )
                            )
                        }
                    },
                    overflow = TextOverflow.Ellipsis,
                    maxLines = Constants.MAX_POST_DESCRIPTION_LINES,
                    style = MaterialTheme.typography.bodyMedium,
                )
                Spacer(modifier = Modifier.height(SpaceMedium))
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = stringResource(
                            R.string.liked_by_x_people,
                            post.likeCount
                        ),
                        style = MaterialTheme.typography.headlineMedium.copy(
                            fontSize = 16.sp
                        )
                    )
                    Text(
                        text = stringResource(
                            R.string.x_Comments,
                            post.commentCount
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

@Composable
fun EngagementButtons(
    modifier: Modifier = Modifier,
    iconSize: Dp = IconSizeMedium,
    isLiked: Boolean = false,
    onLikeClick: (Boolean) -> Unit = {},
    onCommentClick: () -> Unit = {},
    onShareClick: () -> Unit = {}
) {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        IconButton(
            onClick = {
                onLikeClick(!isLiked)
            },
            modifier = Modifier.size(30.dp)
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_favorite),
                tint = if (isLiked) {
                    Color.Red
                } else {
                    TextWhite
                },
                contentDescription = if (isLiked) {
                    stringResource(id = R.string.unlike)
                } else {
                    stringResource(id = R.string.like)
                },
                modifier = Modifier.size(iconSize)
            )
        }
        Spacer(modifier = Modifier.width(SpaceSmall))
        IconButton(
            onClick = {
                onCommentClick()
            },
            modifier = Modifier.size(30.dp)
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_chat),
                contentDescription = stringResource(id = R.string.comment),
                modifier = Modifier.size(iconSize)
            )
        }
        Spacer(modifier = Modifier.width(SpaceSmall))
        IconButton(
            onClick = {
                onShareClick()
            },
            modifier = Modifier.size(30.dp)
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_share),
                contentDescription = stringResource(id = R.string.share),
                modifier = Modifier.size(iconSize)
            )
        }
    }
}

@Composable
fun ActionBar(
    modifier: Modifier = Modifier,
    isLiked: Boolean = false,
    showProfilePicture: Boolean = true,
    onLikeClick: (Boolean) -> Unit = {},
    onCommentClick: () -> Unit = {},
    onShareClick: () -> Unit = {},
    userName: String,
    onUserNameClick: (String) -> Unit = {}
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ){
        Text(
            text = userName,
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier
                .clickable {
                    onUserNameClick(userName)
                }
        )
        Spacer(modifier = Modifier.width(50.dp))
        EngagementButtons(
            isLiked = isLiked,
            onLikeClick = onLikeClick,
            onCommentClick = onCommentClick,
            onShareClick = onShareClick,
        )
    }
}