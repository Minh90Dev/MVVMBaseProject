package com.yadokari.tv.mvvmbase.domain.repository

import com.yadokari.tv.mvvmbase.domain.model.Post

interface PostsRepository {
    suspend fun getPosts(): List<Post>
}