package com.yadokari.tv.mvvmbase.data.source.remote

import com.yadokari.tv.mvvmbase.domain.model.Post
import retrofit2.http.GET

interface ApiService {
    @GET("/posts")
    suspend fun getPosts(): List<Post>
}