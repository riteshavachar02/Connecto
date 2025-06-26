package com.example.connecto.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.Chat
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.PersonOutline
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.connecto.R
import com.example.connecto.domain.models.BottomNavItem
import com.example.connecto.presentation.util.Screen

@Composable
fun StandardScaffold(
    modifier: Modifier = Modifier,
    showBottomBar: Boolean = true,
    navController: NavController,
    bottomNavItem: List<BottomNavItem> = listOf(
        BottomNavItem(
            route = Screen.MainFeedScreen.route,
            icon = ImageVector.vectorResource(id = R.drawable.ic_home),
            contentDescription = stringResource(id = R.string.home)
        ),
        BottomNavItem(
            route = Screen.ChatScreen.route,
            icon = ImageVector.vectorResource(id = R.drawable.ic_chat),
            contentDescription = stringResource(id = R.string.chat),
            alertCount = 10
        ),
        BottomNavItem(
            route = Screen.CreatePostScreen.route,
            icon = ImageVector.vectorResource(id = R.drawable.ic_add),
            contentDescription = stringResource(id = R.string.make_post)
        ),
        BottomNavItem(
            route = Screen.ActivityScreen.route,
            icon = ImageVector.vectorResource(id = R.drawable.ic_notification),
            contentDescription = stringResource(id = R.string.alert),
            alertCount = 100
        ),
        BottomNavItem(
            route = Screen.ProfileScreen.route,
            icon = ImageVector.vectorResource(id = R.drawable.ic_profile),
            contentDescription = stringResource(id = R.string.profile)
        )
    ),
    content: @Composable (PaddingValues) -> Unit
) {

    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                Column {
                    Divider(
                        modifier = Modifier.fillMaxWidth(),
                        thickness = 1.dp,
                        color = MaterialTheme.colorScheme.outline.copy(alpha = 0.3f),
                    )
                    NavigationBar(
                        modifier = Modifier
                            .fillMaxWidth()
                            .size(65.dp),
                        containerColor = MaterialTheme.colorScheme.background,
                        contentColor = MaterialTheme.colorScheme.onBackground,
                        tonalElevation = 5.dp
                    ) {
                        bottomNavItem.forEachIndexed { _, bottomNavItem ->
                            StandardBottomNavItem(
                                icon = bottomNavItem.icon,
                                contentDescription = bottomNavItem.contentDescription,
                                selected = bottomNavItem.route == navController.currentDestination?.route,
                                alertCount = bottomNavItem.alertCount,
                                enabled = bottomNavItem.icon != null
                            ) {
                                if(navController.currentDestination?.route != bottomNavItem.route) {
                                    navController.navigate(bottomNavItem.route)
                                }
                            }
                        }
                    }
                }
            }
        },
        modifier = modifier,
    ) { paddingValues->
        content(paddingValues)
    }
}