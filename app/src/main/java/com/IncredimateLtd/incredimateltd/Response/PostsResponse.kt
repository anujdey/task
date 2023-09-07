package com.IncredimateLtd.incredimateltd.Response

class PostsResponse : ArrayList<PostsResponseItem>()

data class PostsResponseItem(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)