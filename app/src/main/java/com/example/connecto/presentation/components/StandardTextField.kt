package com.example.connecto.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun StandardTextField(
    text: String = "",
    hint: String = "",
    isError: Boolean = false,
    keyboardType: KeyboardType = KeyboardType.Text,
    onValueChange: (String) -> Unit
) {
    TextField(
        value = text,
        onValueChange = onValueChange,
        placeholder = {
            Text(
                text = hint,
                style = MaterialTheme.typography.bodyLarge
            )
        },
        isError = isError,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType
        ),
        singleLine = true,
        modifier = Modifier
            .fillMaxWidth()
        )
}