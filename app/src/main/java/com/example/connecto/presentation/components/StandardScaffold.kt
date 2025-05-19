package com.example.connectify.core.presentation.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Message
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.connecto.domain.models.BottomNavItem
import com.example.connecto.presentation.components.StandardBottomNavItem
import com.example.connecto.presentation.util.Screen

@Composable
fun StandardScaffold(
    modifier: Modifier = Modifier,
    navController: NavController,
    showBottomBar: Boolean = true,
    snackbarHost:  @Composable () -> Unit = {},
    bottomNavItem: List<BottomNavItem> = listOf(
        BottomNavItem(
            route = Screen.MainFeedScreen.route,
            icon = Icons.Outlined.Home,
            contentDescription = "Home"
        ),
        BottomNavItem(
            route = Screen.ChatScreen.route,
            icon = Icons.Outlined.Message,
            contentDescription = "Message"
        ),
        BottomNavItem(
            route = Screen.CreatePostScreen.route,
            icon = Icons.Outlined.Add,
            contentDescription = "Post"
        ),
        BottomNavItem(
            route = Screen.ActivityScreen.route,
            icon = Icons.Outlined.Notifications,
            contentDescription = "Activity"
        ),
        BottomNavItem(
            route = Screen.ProfileScreen.route,
            icon = Icons.Outlined.Person,
            contentDescription = "Profile"
        )
    ),
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.background,
        snackbarHost = snackbarHost,
        bottomBar = {
            if(showBottomBar) {
                NavigationBar(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .drawBehind {
                            drawIntoCanvas { canvas ->
                                val paint = android.graphics.Paint().apply {
                                    color = android.graphics.Color.BLACK
                                    setShadowLayer(
                                        36f,
                                        0f,
                                        12f,
                                        android.graphics.Color.argb(150, 0, 0, 0)
                                    )
                                }
                                canvas.nativeCanvas.drawRect(
                                    0f,
                                    0f,
                                    size.width,
                                    size.height,
                                    paint
                                )
                            }
                        },
                    containerColor = MaterialTheme.colorScheme.background
                ) {
                    bottomNavItem.forEachIndexed { _, bottomNavItem ->
                        StandardBottomNavItem(
                            icon = bottomNavItem.icon,
                            contentDescription = bottomNavItem.contentDescription,
                            selected = navController.currentDestination?.route?.startsWith(bottomNavItem.route) == true,
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
    ) { paddingValues  ->
        content(paddingValues)
    }
}