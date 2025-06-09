package com.example.connecto.presentation.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.connecto.R
import com.example.connecto.domain.models.User
import com.example.connecto.presentation.components.Post
import com.example.connecto.presentation.profile.components.BannerSection
import com.example.connecto.presentation.profile.components.ProfileHeaderSection
import com.example.connecto.presentation.ui.theme.profilePictureSizeLarge
import com.example.connecto.presentation.ui.theme.spaceSmall
import com.example.connecto.presentation.util.Screen

@Composable
fun ProfileScreen(
    navController: NavController
) {
    val lazyListState = rememberLazyListState()
    val toolbarOffsetY by remember {
        mutableStateOf(0f)
    }
    val toolbarHeightCollapsed = 56.dp
    val bannerHeight = (LocalConfiguration.current.screenWidthDp / 2.5f).dp
    val toolbarHeightExpanded = bannerHeight + profilePictureSizeLarge
    val nestedScrollConnection = remember {
        object : NestedScrollConnection {
            override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                val delta = available.y
                val newOffset = toolbarOffsetY + delta

                return super.onPreScroll(available, source)
            }
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(nestedScrollConnection)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            state = lazyListState
        ) {
            item {
                Spacer(modifier = Modifier.height(toolbarHeightExpanded - profilePictureSizeLarge / 2f))
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
                        .height(spaceSmall)
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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.TopCenter)
        ) {
            BannerSection(
                modifier = Modifier
                    .height(bannerHeight)
            )
            Image(
                painter = painterResource(id = R.drawable.ronaldo_profile),
                contentDescription = stringResource(id = R.string.profile),
                modifier = Modifier
                    .align(CenterHorizontally)
                    .graphicsLayer {
                        translationY = -profilePictureSizeLarge.toPx() / 2f
                    }
                    .size(profilePictureSizeLarge)
                    .clip(CircleShape)
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.onSurface,
                        shape = CircleShape
                    )
            )
        }
    }
}