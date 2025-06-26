package com.example.connecto.presentation.activity

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.connecto.R
import com.example.connecto.domain.models.Activity
import com.example.connecto.domain.util.ActivityAction
import com.example.connecto.presentation.ui.theme.SpaceSmall

@Composable
fun ActivityItem(
    activity: Activity,
    modifier: Modifier = Modifier
) {
    Card(
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background,
            contentColor = MaterialTheme.colorScheme.onBackground
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .height(50.dp)
                .padding(SpaceSmall),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            val fillerText = when(activity.actionType) {
                is ActivityAction.LikedPost ->
                    stringResource(id = R.string.liked)
                is ActivityAction.CommentedOnPost ->
                    stringResource(R.string.commented_on)
            }
            val actionText = when(activity.actionType) {
                is ActivityAction.LikedPost ->
                    stringResource(id = R.string.your_post)
                is ActivityAction.CommentedOnPost ->
                    stringResource(R.string.your_post)
            }
            Text(
                text = buildAnnotatedString {
                    val boldStyle = SpanStyle(fontWeight = FontWeight.Bold)
                    withStyle(boldStyle) {
                        append(text = activity.userName)
                    }
                    append(text = " $fillerText ")
                    withStyle(boldStyle) {
                        append(text = actionText)
                    }
                },
                fontSize = 12.sp,
            )
            Text(
                text = activity.formattedTime,
                fontSize = 12.sp,
                textAlign = TextAlign.Right
            )
        }
    }
}