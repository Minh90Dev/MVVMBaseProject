package com.yadokari.tv.mvvmbase.data.mapper

import com.yadokari.tv.mvvmbase.data.source.local.entity.PostEntity
import com.yadokari.tv.mvvmbase.domain.model.Post

fun Post.toEntity() = PostEntity(
    id = id,
    userId = userId,
    title = title,
    body = body
)

fun PostEntity.toPost() = Post(
    id = id,
    userId = userId,
    title = title,
    body = body
)