package com.example.connecto.presentation.profile.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.example.connecto.R
import com.example.connecto.domain.models.User
import com.example.connecto.presentation.ui.theme.spaceLarge

@Composable
fun ProfileState(
    user: User,
    modifier: Modifier = Modifier,
    isOwnProfile: Boolean = false,
    isFollowing: Boolean = false,
    onFollowClick: () -> Unit = {}
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        ProfileNumber(
            number = user.followersCount,
            text = stringResource(id = R.string.followers)
        )
        Spacer(modifier = Modifier.width(spaceLarge))
        ProfileNumber(
            number = user.followingCount,
            text = stringResource(id = R.string.following)
        )
        Spacer(modifier = Modifier.width(spaceLarge))
        ProfileNumber(
            number = user.postCount,
            text = stringResource(id = R.string.posts)
        )
        if (isOwnProfile) {
            Spacer(modifier = Modifier.width(spaceLarge))
            Button(
                onClick = onFollowClick,
                colors = ButtonDefaults.buttonColors(
                    if (isFollowing) {
                        Color.Red
                    } else MaterialTheme.colorScheme.primary
                )
            ) {
                Text(
                    text = if (isFollowing) {
                        stringResource(id = R.string.unfollow)
                    } else stringResource(id = R.string.follow),
                    color = if(isFollowing) {
                        Color.White
                    } else MaterialTheme.colorScheme.onPrimary
                )
            }
        }
    }
}