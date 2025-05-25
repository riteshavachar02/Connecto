package com.example.connecto.domain.models

import com.example.connecto.domain.util.ActivityAction

data class Activity(
    val userName: String,
    val actionType: ActivityAction,
    val timeStamp: Long
)
