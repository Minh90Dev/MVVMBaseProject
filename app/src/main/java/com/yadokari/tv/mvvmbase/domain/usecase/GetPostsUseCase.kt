package com.yadokari.tv.mvvmbase.domain.usecase

import com.yadokari.tv.mvvmbase.domain.model.Post
import com.yadokari.tv.mvvmbase.domain.repository.PostsRepository
import com.yadokari.tv.mvvmbase.domain.usecase.base.UseCase

class GetPostsUseCase constructor(
    private val postsRepository: PostsRepository
) : UseCase<List<Post>, Any?>() {

    override suspend fun run(params: Any?): List<Post> {
        return postsRepository.getPosts()
    }

}