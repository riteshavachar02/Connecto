package com.example.connecto.presentation.splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.connecto.R
import com.example.connecto.presentation.util.Screen
import com.example.connecto.utils.Constants
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavController
) {

    val scale = remember {
        Animatable(0f)
    }
    val alpha = remember {
        Animatable(0f)
    }
    val rotation = remember {
        Animatable(0f)
    }
    val overshootInterpolator = remember {
        OvershootInterpolator(2f)
    }
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.5f,
            animationSpec = tween(
                durationMillis = 500,
                easing = {
                    overshootInterpolator.getInterpolation(it)
                }
            )
        )
        alpha.animateTo(
            targetValue = 1f,
            animationSpec = tween(
                durationMillis = 600,
                easing = {
                    overshootInterpolator.getInterpolation(it)
                }
            )
        )
        rotation.animateTo(
            targetValue = 360f,
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    overshootInterpolator.getInterpolation(it)
                }
            )
        )
        delay(Constants.SPLASH_SCREEN_DURATION)
        navController.popBackStack()
        navController.navigate(Screen.LoginScreen.route)
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = "Logo",
            // Added alpha and rotate modifiers to apply fade-in and rotation animations
            modifier = Modifier
                .scale(scale.value)
                .alpha(alpha.value)
                .rotate(rotation.value)
        )
    }
}