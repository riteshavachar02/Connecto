package com.example.connecto.domain.util

sealed class ActivityAction {
    object LikedPost: ActivityAction()
    object CommentedOnPost: ActivityAction()
}
