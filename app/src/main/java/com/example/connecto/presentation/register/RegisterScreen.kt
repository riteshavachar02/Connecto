package com.example.connecto.presentation.register

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.PersonOutline
import androidx.compose.material.icons.outlined.Security
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.connecto.R
import com.example.connecto.presentation.components.StandardTextField
import com.example.connecto.presentation.ui.theme.SpaceLarge
import com.example.connecto.presentation.ui.theme.SpaceMedium
import com.example.connecto.presentation.util.Screen

@Composable
fun RegisterScreen (
    navController: NavController,
    viewModel: RegisterViewModel = hiltViewModel()
) {
    Box (
        modifier = Modifier
            .fillMaxSize()
            .padding(
                start = SpaceLarge,
                end = SpaceLarge,
                top = SpaceLarge,
                bottom = 50.dp
            )
    ) {
        Column (
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center),
        ) {
            Text(
                text = stringResource(R.string.register),
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.headlineLarge,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(SpaceMedium))
            StandardTextField (
                text = viewModel.emailText.value,
                onValueChange = {
                    viewModel.setEmailText(it)
                },
                error = viewModel.emailError.value,
                leadingIcon = Icons.Outlined.Email,
                keyboardType = KeyboardType.Email,
                hint = stringResource(R.string.email_hint)
            )
            Spacer(modifier = Modifier.height(SpaceMedium))
            StandardTextField (
                text = viewModel.usernameText.value,
                onValueChange = {
                    viewModel.setUsernameText(it)
                },
                error = viewModel.usernameError.value,
                leadingIcon = Icons.Outlined.PersonOutline,
                hint = stringResource(R.string.username_hint)
            )
            Spacer(modifier = Modifier.height(SpaceMedium))
            StandardTextField (
                text = viewModel.passwordText.value,
                onValueChange = {
                    viewModel.setPasswordText(it)
                },
                error = viewModel.passwordError.value,
                hint = stringResource(R.string.password_hint),
                leadingIcon = Icons.Outlined.Security,
                keyboardType = KeyboardType.Password,
                isPasswordVisible = viewModel.showPassword.value,
                onPasswordToggleClick = {
                    viewModel.setShowPassword(it)
                }
            )
            Spacer(modifier = Modifier.height(SpaceMedium))
            Button(
                onClick = {
                    navController.navigate(Screen.LoginScreen.route)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(SpaceLarge)
            ) {
                Text(
                    text = stringResource(id = R.string.register),
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontSize = 15.sp
                )
            }
        }
        Text(
            text = buildAnnotatedString {
                append(stringResource(R.string.already_have_an_account_yet))
                append(" ")
                val signupText = stringResource(R.string.sign_in)
                withStyle(
                    style = SpanStyle(
                        color = MaterialTheme.colorScheme.primary
                    )
                ) {
                    append(signupText)
                }
            },
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .clickable {
                    navController.navigate(
                        Screen.LoginScreen.route
                    )
                }
        )
    }
}