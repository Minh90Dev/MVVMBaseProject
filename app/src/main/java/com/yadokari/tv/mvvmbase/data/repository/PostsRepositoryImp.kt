package com.yadokari.tv.mvvmbase.data.repository

import com.yadokari.tv.mvvmbase.data.source.remote.ApiService
import com.yadokari.tv.mvvmbase.domain.model.Post
import com.yadokari.tv.mvvmbase.domain.repository.PostsRepository

class PostsRepositoryImp(private val apiService: ApiService) : PostsRepository {
    override suspend fun getPosts(): List<Post> {
        return apiService.getPosts()
    }
}
