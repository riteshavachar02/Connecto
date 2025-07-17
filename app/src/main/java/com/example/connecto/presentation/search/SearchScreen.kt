package com.example.connecto.presentation.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PersonAdd
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.connecto.R
import com.example.connecto.domain.models.User
import com.example.connecto.presentation.components.StandardTextField
import com.example.connecto.presentation.components.StandardToolBar
import com.example.connecto.presentation.components.UserProfileItem
import com.example.connecto.presentation.ui.theme.IconSizeMedium
import com.example.connecto.presentation.ui.theme.SpaceLarge
import com.example.connecto.presentation.ui.theme.SpaceMedium
import com.example.connecto.presentation.util.states.StandardTextFieldState

@Composable
fun SearchScreen(
    navController: NavController,
    viewModel: SearchViewModel = hiltViewModel()
) {
    Column(modifier = Modifier.fillMaxSize()) {
        StandardToolBar(
            navController = navController,
            modifier = Modifier.fillMaxWidth(),
            showArrowBack = true,
            title = {
                Text(
                    text = stringResource(id = R.string.search),
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(SpaceLarge)
        ) {
            StandardTextField(
                modifier = Modifier.fillMaxWidth(),
                text = viewModel.searchState.value.text,
                error = viewModel.searchState.value.error,
                hint = stringResource(id = R.string.your_bio),
                singleLine = false,
                maxLines = 3,
                maxLength = 100,
                leadingIcon = ImageVector.vectorResource(id = R.drawable.ic_search),
                onValueChange = {
                    viewModel.setSearchState(StandardTextFieldState(text = it))
                }
            )

            Spacer(modifier = Modifier.height(SpaceMedium))

            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(10) {
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
}
