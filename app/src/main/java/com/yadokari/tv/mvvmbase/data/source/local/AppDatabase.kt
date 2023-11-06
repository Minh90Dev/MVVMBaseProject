package com.yadokari.tv.mvvmbase.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.yadokari.tv.mvvmbase.data.source.local.dao.PostDao
import com.yadokari.tv.mvvmbase.data.source.local.entity.PostEntity

@Database(entities = [PostEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract val postDao: PostDao

    companion object {
        const val DB_NAME = "BaseDatabase.db"
    }
}