package com.example.connecto.presentation.main_feed

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PersonAdd
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.example.connecto.R
import com.example.connecto.domain.models.User
import com.example.connecto.presentation.components.StandardToolBar
import com.example.connecto.presentation.components.UserProfileItem
import com.example.connecto.presentation.ui.theme.IconSizeMedium
import com.example.connecto.presentation.ui.theme.SpaceMedium

@Composable
fun PersonListScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        StandardToolBar(
            modifier = Modifier.fillMaxWidth(),
            navController = navController,
            showArrowBack = true,
            title = {
                Text(
                    text = stringResource(id = R.string.liked_by)
                )
            }
        )
        Spacer(modifier = Modifier.height(SpaceMedium))
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(15) {
                UserProfileItem(
                    user = User(
                        profilePictureUrl = "",
                        userName = "Cristiano Ronaldo",
                        description = "Greatness isn't luck — it's relentless hard work and discipline.",
                        followersCount = 250,
                        followingCount = 200,
                        postCount = 50
                    ),
                    actionIcon = {
                        Icon(
                            imageVector = Icons.Default.PersonAdd,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onBackground,
                            modifier = Modifier.size(IconSizeMedium)
                        )
                    }
                )
                Spacer(modifier = Modifier.height(SpaceMedium))
            }
        }
    }
}