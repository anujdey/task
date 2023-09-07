package com.IncredimateLtd.incredimateltd.Interface

import com.IncredimateLtd.incredimateltd.Response.PostsResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiServices {

    @GET("posts")
    fun getposts(
    ): Call<PostsResponse>
}