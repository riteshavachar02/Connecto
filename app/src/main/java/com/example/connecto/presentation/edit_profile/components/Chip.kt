package com.example.connecto.presentation.edit_profile.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.connecto.presentation.ui.theme.SpaceSmall

@Composable
fun Chip(
    modifier: Modifier = Modifier,
    text: String,
    selected: Boolean = false,
    selectedColor: Color = MaterialTheme.colorScheme.primary,
    unSelectedColor: Color = MaterialTheme.colorScheme.onSurface,
    onChipClick : () -> Unit
) {
    Text(
        text = text,
        color = if(selected) selectedColor else unSelectedColor,
        modifier = modifier
            .clip(RoundedCornerShape(50.dp))
            .border(
                width = 1.dp,
                color = if(selected) selectedColor else unSelectedColor,
                shape = RoundedCornerShape(50.dp)
            )
            .clickable {
                onChipClick()
            }
            .padding(SpaceSmall)
    )
}