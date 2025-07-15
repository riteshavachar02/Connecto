package com.example.connecto.presentation.edit_profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.connecto.R
import com.example.connecto.presentation.components.StandardTextField
import com.example.connecto.presentation.components.StandardToolBar
import com.example.connecto.presentation.edit_profile.components.Chip
import com.example.connecto.presentation.ui.theme.ProfilePictureSizeLarge
import com.example.connecto.presentation.ui.theme.SpaceLarge
import com.example.connecto.presentation.ui.theme.SpaceMedium
import com.example.connecto.presentation.util.Screen
import com.example.connecto.presentation.util.states.StandardTextFieldState
import kotlin.random.Random


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun EditProfileScreen(
    navController: NavController,
    viewModel: EditProfileViewModel = hiltViewModel(),
    profilePictureSize: Dp = ProfilePictureSizeLarge
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        StandardToolBar(
            navController = navController,
            title = {
                Text(
                    text = stringResource(id = R.string.edit_profile),
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground
                )
            },
            modifier = Modifier.fillMaxWidth(),
            showArrowBack = true,
            navActions = {
                IconButton(onClick = {
                    navController.navigate(Screen.ProfileScreen.route)
                }) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = stringResource(id = R.string.submit),
                        tint = MaterialTheme.colorScheme.onBackground
                    )
                }
            }
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            BannerEditSection(
                bannerImage = painterResource(id = R.drawable.channelart),
                profileImage = painterResource(id = R.drawable.default_user),
                profilePictureSize = profilePictureSize
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(SpaceLarge)
            ) {
                Spacer(modifier = Modifier.height(SpaceMedium))
                StandardTextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = viewModel.usernameState.value.text,
                    error = viewModel.usernameState.value.error,
                    hint = stringResource(id = R.string.username_hint),
                    leadingIcon = Icons.Default.Person,
                    onValueChange = {
                        viewModel.setUsernameState(
                            StandardTextFieldState(
                                text = it
                            )
                        )
                    }
                )
                Spacer(modifier = Modifier.height(SpaceMedium))
                StandardTextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = viewModel.githubTextFieldState.value.text,
                    error = viewModel.githubTextFieldState.value.error,
                    hint = stringResource(id = R.string.github_profile_url),
                    leadingIcon = ImageVector.vectorResource(id = R.drawable.ic_github_icon_1),
                    onValueChange = {
                        viewModel.setGithubTextFieldState(
                            StandardTextFieldState(
                                text = it
                            )
                        )
                    },
                )
                Spacer(modifier = Modifier.height(SpaceMedium))
                StandardTextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = viewModel.linkedInTextFieldState.value.text,
                    error = viewModel.linkedInTextFieldState.value.error,
                    hint = stringResource(id = R.string.linkedIn_profile_url),
                    leadingIcon = ImageVector.vectorResource(id = R.drawable.ic_linkedin_icon_1),
                    onValueChange = {
                        viewModel.setLinkedInTextFieldState(
                            StandardTextFieldState(
                                text = it
                            )
                        )
                    },
                )
                Spacer(modifier = Modifier.height(SpaceMedium))
                StandardTextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = viewModel.instagramTextFieldState.value.text,
                    error = viewModel.instagramTextFieldState.value.error,
                    hint = stringResource(id = R.string.instagram_profile_url),
                    leadingIcon = ImageVector.vectorResource(R.drawable.ic_instagram_glyph_1),
                    onValueChange = {
                        viewModel.setInstagramTextFieldState(
                            StandardTextFieldState(
                                text = it
                            )
                        )
                    },
                )
                Spacer(modifier = Modifier.height(SpaceMedium))
                StandardTextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = viewModel.bioTextFieldState.value.text,
                    error = viewModel.bioTextFieldState.value.error,
                    hint = stringResource(id = R.string.your_bio),
                    singleLine = false,
                    maxLines = 3,
                    maxLength = 100,
                    leadingIcon = ImageVector.vectorResource(id = R.drawable.ic_description),
                    onValueChange = {
                        viewModel.setBioTextFieldState(
                            StandardTextFieldState(
                                text = it
                            )
                        )
                    },
                )
                Spacer(modifier = Modifier.height(SpaceMedium))
                Text(
                    text = stringResource(id = R.string.select_top_skills),
                    style = MaterialTheme.typography.headlineMedium,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.align(CenterHorizontally)
                )
                Spacer(modifier = Modifier.height(SpaceMedium))
                FlowRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(SpaceMedium, Alignment.CenterHorizontally),
                    verticalArrangement = Arrangement.spacedBy(SpaceMedium, Alignment.CenterVertically)
                ) {
                    listOf(
                        "Kotlin",
                        "Java",
                        "JavaScript",
                        "C++",
                        "C",
                        "Dart",
                        "Assembly",
                        "HTML"
                    ).forEach{
                        Chip(
                            text = it,
                            selected = Random.nextInt(2) == 0
                        ) { }
                    }
                }
            }
        }
    }
}

@Composable
fun BannerEditSection(
    bannerImage : Painter,
    profileImage : Painter,
    profilePictureSize: Dp = ProfilePictureSizeLarge,
    onBannerImageClick : () -> Unit = {},
    onProfileImageClick : () -> Unit = {}
) {
    val bannerHeight = (LocalConfiguration.current.screenWidthDp / 2.5f).dp

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(bannerHeight + profilePictureSize / 2f)
    ) {
        Image(
            painter = bannerImage,
            contentDescription = stringResource(id = R.string.banner_image),
            modifier = Modifier
                .fillMaxWidth()
                .height(bannerHeight)
                .clickable {
                    onBannerImageClick()
                }
        )
        Image(
            painter = profileImage,
            contentDescription = stringResource(id = R.string.profile),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .size(ProfilePictureSizeLarge)
                .clip(CircleShape)
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.onSurface,
                    shape = CircleShape
                )
                .clickable {
                    onProfileImageClick()
                }
        )
    }
}

