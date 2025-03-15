package com.example.connecto.presentation.ui.theme

import GreenAccent
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import DarkGray
import LightGray
import MediumGray
import TextWhite

// Define the dark color scheme using your custom colors
private val DarkColorScheme = darkColorScheme(
    primary = GreenAccent,
    background = DarkGray,
    onBackground = TextWhite,
    onPrimary = DarkGray,
    surface = MediumGray,
    onSurface = LightGray
)

@Composable
fun ConnectoTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = DarkColorScheme,
        typography = Typography,
        content = content
    )
}
