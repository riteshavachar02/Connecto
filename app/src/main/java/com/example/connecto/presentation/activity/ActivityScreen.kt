package com.example.connecto.presentation.activity

import MediumGray
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.example.connecto.R
import com.example.connecto.domain.models.Activity
import com.example.connecto.domain.util.ActivityAction
import com.example.connecto.domain.util.DateFormatUtil
import com.example.connecto.presentation.components.StandardToolBar
import com.example.connecto.presentation.ui.theme.spaceSmall
import kotlin.random.Random

@Composable
fun ActivityScreen(
    navController: NavController,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MediumGray)
    ) {
        StandardToolBar(
            title = {
                Text(
                    text = stringResource(id = R.string.activity),
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground
                )
            },
            navController = navController,
            showArrowBack = false,
            modifier = Modifier.fillMaxWidth(),
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            contentPadding = PaddingValues(top = spaceSmall)
        ) {
            items(20) {
                ActivityItem(
                    activity = Activity(
                        userName = "Cristiano Ronaldo",
                        actionType = if (Random.nextInt(2) == 0) {
                            ActivityAction.LikedPost
                        } else ActivityAction.CommentedOnPost,
                        formattedTime = DateFormatUtil.timestampToFormattedString(
                            timestamp = System.currentTimeMillis(),
                            pattern = "MMM dd, HH:mm"
                        ),
                    )
                )
                if (it<19) {
                    Spacer(modifier = Modifier.height(spaceSmall))
                }
            }
        }
    }
}