package com.melaniedura.hiltplayground.framework.datasource.cache.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.melaniedura.hiltplayground.framework.datasource.cache.model.BlogCacheEntity

@Database(entities = [BlogCacheEntity::class], version = 1, exportSchema = false)
abstract class BlogDatabase: RoomDatabase() {

    abstract fun blogDao(): BlogDao

    companion object{
        val DATABASE_NAME: String = "blog_db"
    }
}