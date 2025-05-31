package com.example.connecto.presentation.edit_profile

import MediumGray
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.connecto.R
import com.example.connecto.presentation.components.StandardTextField
import com.example.connecto.presentation.components.StandardToolBar
import com.example.connecto.presentation.ui.theme.profilePictureSizeLarge
import com.example.connecto.presentation.ui.theme.spaceMedium
import com.example.connecto.presentation.util.Screen

@Composable
fun EditProfileScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MediumGray)
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
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(MediumGray)
        ) {  }
        Image(
            painter = painterResource(id = R.drawable.channelart),
            contentDescription = stringResource(id = R.string.banner_image),
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    MaterialTheme.colorScheme.background
                )
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = MaterialTheme.colorScheme.background
                )
                .offset(y = -profilePictureSizeLarge / 2f),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(id = R.drawable.ronaldo_profile),
                contentDescription = stringResource(id = R.string.profile),
                modifier = Modifier
                    .size(profilePictureSizeLarge)
                    .clip(CircleShape)
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.onSurface,
                        shape = CircleShape
                    )
                    .background(
                        color = MaterialTheme.colorScheme.surface
                    )
            )
            Box(
                modifier = Modifier
                    .padding(spaceMedium)
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.background)
            ) {
                StandardTextField(

                ) {}
            }
        }
    }
}

@Preview
@Composable
private fun EditProfileScreenPreview() {
    EditProfileScreen(navController = rememberNavController())
}