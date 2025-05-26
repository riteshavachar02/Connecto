package com.example.connecto.presentation.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RowScope.StandardBottomNavItem(
    modifier: Modifier = Modifier,
    icon: ImageVector? = null ,
    contentDescription: String? = null,
    selected: Boolean = false,
    alertCount: Int? = null,
    selectedColor: Color = MaterialTheme.colorScheme.primary,
    unselectedColor: Color = MaterialTheme.colorScheme.onSurfaceVariant,
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    if(alertCount != null && alertCount < 0) {
        throw IllegalArgumentException("Alert count can't be negative")
    }
    val lineLength = animateFloatAsState(
        targetValue = if (selected) 1f else 0f,
        animationSpec = tween(durationMillis = 300),
        label = "LineLengthAnimation"
    )
    NavigationBarItem(
        selected = selected,
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = MaterialTheme.colorScheme.primary,
            selectedTextColor = MaterialTheme.colorScheme.primary,
            indicatorColor = Color.Transparent,
            unselectedIconColor = MaterialTheme.colorScheme.onBackground,
            unselectedTextColor = MaterialTheme.colorScheme.onBackground,
            disabledIconColor = Color.Transparent,
            disabledTextColor = Color.Transparent,
        ),
        icon = {
            Box(
                modifier = Modifier
                    .size(width = 40.dp, height = 50.dp)
                    .drawBehind {
                        if(lineLength.value > 0f) {
                            drawLine(
                                color = if (selected) selectedColor
                                else unselectedColor,
                                start = Offset(
                                    size.width / 2f - lineLength.value * 15.dp.toPx(),
                                    size.height
                                ),
                                end = Offset(
                                    size.width / 2f + lineLength.value * 15.dp.toPx(),
                                    size.height
                                ),
                                strokeWidth = 2.dp.toPx(),
                                cap = StrokeCap.Round
                            )
                        }
                    }
            ) {
                if (icon!= null) {
                    Icon(
                        imageVector = icon,
                        contentDescription = contentDescription,
                        modifier = Modifier
                            .size(30.dp)
                            .align(Alignment.Center),
                    )
                }
                if (alertCount!= null) {
                    val alertText = if (alertCount > 99) {
                        "99+"
                    } else{
                        alertCount.toString()
                    }
                    Text(
                        text = alertText,
                        color = MaterialTheme.colorScheme.onPrimary,
                        fontWeight = FontWeight.Bold,
                        fontSize = 8.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .align(Alignment.TopCenter)
                            .offset(15.dp)
                            .size(20.dp)
                            .clip(CircleShape)
                            .background(color = MaterialTheme.colorScheme.primary)
                    )
                }
            }
        }
    )
}