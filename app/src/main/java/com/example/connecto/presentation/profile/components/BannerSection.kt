package com.example.connecto.presentation.profile.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.connecto.R
import com.example.connecto.presentation.ui.theme.SpaceMedium
import com.example.connecto.presentation.ui.theme.SpaceSmall
import com.example.connecto.presentation.util.toPx

@Composable
fun BannerSection(
    modifier: Modifier = Modifier,
    iconSize: Dp = 35.dp,
    leftIconModifier: Modifier = Modifier,
    rightIconModifier: Modifier = Modifier,
    onGitHubClick: () -> Unit = {},
    onInstagramClick: () -> Unit = {},
    onLinkedinClick: () -> Unit = {}
) {
    Column(modifier = modifier) {
        BoxWithConstraints(
            modifier = modifier
        ) {
            // Background Banner Image
            Image(
                painter = painterResource(id = R.drawable.channelart),
                contentDescription = stringResource(id = R.string.banner_image),
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            // Dark gradient overlay for better icon visibility
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(Color.Transparent, Color.Black),
                            startY = constraints.maxHeight - iconSize.toPx() * 2f
                        )
                    )
            )

            // Left Row with Tech Logos
            Row(
                modifier = leftIconModifier
                    .height(iconSize)
                    .align(Alignment.BottomStart)
                    .padding(SpaceSmall)
            ) {
                Spacer(modifier = Modifier.width(SpaceSmall))
                Image(
                    painter = painterResource(id = R.drawable.ic_js_logo),
                    contentDescription = "JavaScript Logo",
                    modifier = Modifier.height(iconSize)
                )
                Spacer(modifier = Modifier.width(SpaceMedium))
                Image(
                    painter = painterResource(id = R.drawable.ic_csharp_logo),
                    contentDescription = "C# Logo",
                    modifier = Modifier.height(iconSize)
                )
                Spacer(modifier = Modifier.width(SpaceMedium))
                Image(
                    painter = painterResource(id = R.drawable.ic_kotlin_logo),
                    contentDescription = "Kotlin Logo",
                    modifier = Modifier.height(iconSize)
                )
            }

            // Right Row with Social Icons
            Row(
                modifier = rightIconModifier
                    .height(iconSize)
                    .align(Alignment.BottomEnd)
                    .padding(SpaceSmall)
            ) {
                IconButton(
                    onClick = onGitHubClick,
                    modifier = Modifier.size(iconSize)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_github_icon_1),
                        contentDescription = "GitHub Logo",
                        modifier = Modifier.size(iconSize)
                    )
                }
                IconButton(
                    onClick = onLinkedinClick,
                    modifier = Modifier.size(iconSize)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_linkedin_icon_1),
                        contentDescription = "LinkedIn Logo",
                        modifier = Modifier.size(iconSize)
                    )
                }
                IconButton(
                    onClick = onInstagramClick,
                    modifier = Modifier.size(iconSize)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_instagram_glyph_1),
                        contentDescription = "Instagram Logo",
                        modifier = Modifier.size(iconSize)
                    )
                }
            }
        }
    }
}