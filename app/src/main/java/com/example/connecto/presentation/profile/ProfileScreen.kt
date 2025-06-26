package com.example.connecto.presentation.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.connecto.R
import com.example.connecto.domain.models.User
import com.example.connecto.presentation.components.Post
import com.example.connecto.presentation.profile.components.BannerSection
import com.example.connecto.presentation.profile.components.ProfileHeaderSection
import com.example.connecto.presentation.ui.theme.ProfilePictureSizeLarge
import com.example.connecto.presentation.ui.theme.SpaceSmall
import com.example.connecto.presentation.util.Screen
import com.example.connecto.presentation.util.toPx

@Composable
fun ProfileScreen(
    navController: NavController,
    viewModel: ProfileViewModel = hiltViewModel()
) {
    // === State and Config ===
    val lazyListState = rememberLazyListState()
    val toolbarOffsetY by viewModel.toolbarOffsetY
    val expandedRatio by viewModel.expendedRatio

    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val bannerHeight = (screenWidth / 2.5f)
    val toolbarHeightCollapsed = 75.dp
    val toolbarHeightExpanded = bannerHeight + ProfilePictureSizeLarge
    val maxOffset = toolbarHeightExpanded - toolbarHeightCollapsed

    val iconSizeExpanded = 35.dp
    val imageCollapsedOffsetY = remember { (toolbarHeightCollapsed - ProfilePictureSizeLarge / 2f) / 2f }
    val iconCollapsedOffsetY = (toolbarHeightCollapsed - iconSizeExpanded) / 2f

    val iconCenterOffset = (screenWidth.toPx() / 4f -
            ProfilePictureSizeLarge.toPx() / 4f -
            SpaceSmall.toPx()) / 2f

    // === Scroll Behavior ===
    val nestedScrollConnection = remember {
        object : NestedScrollConnection {
            override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                val delta = available.y
                if (delta > 0f && lazyListState.firstVisibleItemIndex != 0) return Offset.Zero

                val newOffset = (toolbarOffsetY + delta).coerceIn(-maxOffset.toPx(), 0f)
                viewModel.setToolbarOffsetY(newOffset)
                viewModel.setExpandedRatio((toolbarOffsetY + maxOffset.toPx()) / maxOffset.toPx())
                return Offset.Zero
            }
        }
    }

    // === Main Layout ===
    Box(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(nestedScrollConnection)
            .padding(bottom = 33.dp)
    ) {
        // === Post Feed ===
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            state = lazyListState
        ) {
            item {
                Spacer(modifier = Modifier.height(toolbarHeightExpanded - ProfilePictureSizeLarge / 2f))
            }

            item {
                ProfileHeaderSection(
                    user = User(
                        profilePictureUrl = "",
                        userName = "Cristiano Ronaldo",
                        description = "Greatness isn't luck — it's relentless hard work and discipline.",
                        followersCount = 250,
                        followingCount = 200,
                        postCount = 50
                    ),
                    onEditClick = {
                        navController.navigate(
                            Screen.EditProfileScreen.route
                        )
                    }
                )
            }

            items(20) {
                Spacer(modifier = Modifier
                    .height(SpaceSmall)
                    .offset(y = -ProfilePictureSizeLarge / 2f)
                )

                Post(
                    post = com.example.connecto.domain.models.Post(
                        userName = "Cristiano Ronaldo",
                        imageUrl = "",
                        profileUrl = "",
                        description = "Greatness isn't luck — it's relentless hard work and discipline. " +
                                "Cristiano Ronaldo continues to inspire millions with every move.",
                        likeCount = 17,
                        commentCount = 10
                    ),
                    showProfilePicture = false,
                    onPostClick = {
                        navController.navigate(Screen.PostDetailScreen.route)
                    },
                    modifier = Modifier.offset(y = -ProfilePictureSizeLarge / 2f)
                )
            }
        }

        // === Banner + Profile Image ===
        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.TopCenter)
        ) {
            BannerSection(
                modifier = Modifier.height(
                    (bannerHeight * expandedRatio).coerceIn(toolbarHeightCollapsed, bannerHeight)
                ),
                leftIconModifier = Modifier.graphicsLayer {
                    translationY = (1f - expandedRatio) * -iconCollapsedOffsetY.toPx()
                    translationX = (1f - expandedRatio) * iconCenterOffset
                },
                rightIconModifier = Modifier.graphicsLayer {
                    translationY = (1f - expandedRatio) * -iconCollapsedOffsetY.toPx()
                    translationX = (1f - expandedRatio) * -iconCenterOffset
                }
            )

            Image(
                painter = painterResource(id = R.drawable.ronaldo_profile),
                contentDescription = stringResource(id = R.string.profile),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .graphicsLayer {
                        translationY = -ProfilePictureSizeLarge.toPx() / 2f -
                                (1f - expandedRatio) * imageCollapsedOffsetY.toPx()
                        transformOrigin = TransformOrigin(0.5f, 0f)
                        val scale = 0.5f + expandedRatio * 0.5f
                        scaleX = scale
                        scaleY = scale
                    }
                    .size(ProfilePictureSizeLarge)
                    .clip(CircleShape)
                    .border(1.dp, MaterialTheme.colorScheme.onSurface, CircleShape)
            )
        }
    }
}
