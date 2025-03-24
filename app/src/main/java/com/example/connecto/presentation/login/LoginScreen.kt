package com.example.connecto.presentation.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.connecto.R
import com.example.connecto.presentation.components.StandardTextField
import com.example.connecto.presentation.ui.theme.spaceMedium
import com.example.connecto.presentation.ui.theme.spaceSmall

@Composable
fun LoginScreen (
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel()
) {
    Column (
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = spaceMedium),
    ) {
       Text(
           text = stringResource(R.string.login),
           color = MaterialTheme.colorScheme.onBackground,
           style = MaterialTheme.typography.bodyLarge
       )

        Spacer(modifier = Modifier.height(spaceSmall))

        StandardTextField (
            text = viewModel.usernameText.value,
            onValueChange = {
                viewModel.setUsernameText(it)
            },
            hint = stringResource(R.string.login_hint)
        )

        Spacer(modifier = Modifier.height(spaceSmall))

        StandardTextField (
            text = viewModel.passwordText.value,
            onValueChange = {
                viewModel.setPasswordText(it)
            },
            hint = stringResource(R.string.password_hint),
            keyboardType = KeyboardType.Password
        )

    }
}