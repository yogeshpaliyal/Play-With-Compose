package com.omkarcodes.instagramclone.data.model

data class Post(
    val username: String,
    val userImage: Int,
    val postImage: Int,
    val caption: String,
    val likeCount: Int,
    val commentCount: Int,
)
