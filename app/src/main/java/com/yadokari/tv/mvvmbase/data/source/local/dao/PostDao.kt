package com.yadokari.tv.mvvmbase.data.source.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.yadokari.tv.mvvmbase.data.source.local.entity.PostEntity

@Dao
interface PostDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(post: PostEntity): Int

    @Query("SELECT * FROM Post")
    fun loadAll(): MutableList<PostEntity>

    @Delete
    fun delete(post: PostEntity)

    @Query("DELETE FROM Post")
    fun deleteAll()

    @Query("SELECT * FROM Post where id = :postId")
    fun loadOneByPostId(postId: Int): PostEntity?

    @Query("SELECT * FROM Post where title = :postTitle")
    fun loadOneByPostTitle(postTitle: String): PostEntity?

    @Update
    fun update(post: PostEntity)
}