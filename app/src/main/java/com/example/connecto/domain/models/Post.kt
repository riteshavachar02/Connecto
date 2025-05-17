package com.example.connecto.domain.models

data class Post(
    val userName: String,
    val description: String,
    val imageUrl: String,
    val profileUrl: String,
    val likeCount: Int,
    val commentCount: Int
)
