package com.yadokari.tv.mvvmbase.data.source.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Post")
data class PostEntity(
    @PrimaryKey var id: Int,
    var userId: Int,
    var title: String,
    var body: String
)