package com.example.instagram.data

data class Post(
    val id: Int,
    val username: String,
    val profileImageRes: Int,
    val imageResList: List<Int>,
    val caption: String,
    val likeCount: Int,
    val commentCount: Int,
    val repostCount: Int,
    val shareCount: Int
)