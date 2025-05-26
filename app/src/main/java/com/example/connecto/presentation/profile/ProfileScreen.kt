package com.example.connecto.presentation.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.example.connecto.R
import com.example.connecto.presentation.components.StandardToolBar
import com.example.connecto.presentation.profile.components.BannerSection

@Composable
fun ProfileScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
    ) {
        StandardToolBar(
            modifier = Modifier.fillMaxWidth(),
            navController = navController,
            showArrowBack = false,
            navActions = {
                IconButton(
                    onClick = {}
                ) {
                    Icon(
                        imageVector = Icons.Default.MoreVert,
                        contentDescription = stringResource(id = R.string.more_option)
                    )
                }
            },
            title = {
                Text(
                    text = stringResource(id = R.string.profile),
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground
                )
            },
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
        ) {
            item() {
                BannerSection(
                    modifier = Modifier
                        .aspectRatio(2.5f),
                )
            }
            items(20) {
            }
        }
    }
}