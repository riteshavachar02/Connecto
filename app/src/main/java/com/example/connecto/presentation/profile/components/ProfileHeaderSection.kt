package com.example.connecto.presentation.profile.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.connecto.R
import com.example.connecto.domain.models.User
import com.example.connecto.presentation.ui.theme.profilePictureSizeLarge
import com.example.connecto.presentation.ui.theme.spaceLarge
import com.example.connecto.presentation.ui.theme.spaceMedium
import com.example.connecto.presentation.ui.theme.spaceSmall

@Composable
fun ProfileHeaderSection(
    modifier: Modifier = Modifier,
    user: User,
    isOwnProfile: Boolean = true,
    onEditClick: () -> Unit = {},
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.background
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            modifier = Modifier
                .offset(
                    x = if (isOwnProfile) {
                        (30.dp + spaceSmall) / 2f
                    } else 0.dp
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = user.userName,
                style = MaterialTheme.typography.headlineLarge.copy(
                    fontSize = 24.sp
                ),
                color = MaterialTheme.colorScheme.onBackground
            )
            Spacer(modifier = Modifier.width(spaceSmall))
            if (isOwnProfile) {
                IconButton(
                    onClick = onEditClick,
                    modifier = Modifier.size(30.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = stringResource(id = R.string.edit),
                        tint = MaterialTheme.colorScheme.onBackground
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(spaceMedium))
        Text(
            text = user.description,
            modifier = Modifier
                .padding(
                    start = spaceMedium,
                    end = spaceMedium
                ),
            style = MaterialTheme.typography.bodyMedium.copy(
                fontSize = 14.sp
            ),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(spaceLarge))
        ProfileState(user = user, isOwnProfile = false)
    }
}