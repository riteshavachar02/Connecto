package com.example.connecto.domain.models

data class User(
    val profilePictureUrl: String,
    val userName: String,
    val description: String,
    val followersCount: Int,
    val followingCount: Int,
    val postCount: Int
)
