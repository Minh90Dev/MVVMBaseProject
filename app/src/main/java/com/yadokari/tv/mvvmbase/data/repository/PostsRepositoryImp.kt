package com.yadokari.tv.mvvmbase.data.repository

import com.yadokari.tv.mvvmbase.data.mapper.toPost
import com.yadokari.tv.mvvmbase.data.source.local.AppDatabase
import com.yadokari.tv.mvvmbase.data.source.remote.ApiService
import com.yadokari.tv.mvvmbase.domain.model.Post
import com.yadokari.tv.mvvmbase.domain.repository.PostsRepository

class PostsRepositoryImp(
    private val database: AppDatabase,
    private val apiService: ApiService
) : PostsRepository {

    override suspend fun getPosts(): List<Post> {
        return apiService.getPosts()
    }

    override suspend fun getPostDetails(postId: Int): Post? {
        database.postDao.loadOneByPostId(postId)?.let {
            return it.toPost()
        }
        return null
    }
}
