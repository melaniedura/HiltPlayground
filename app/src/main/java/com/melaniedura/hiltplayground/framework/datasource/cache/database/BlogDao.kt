package com.melaniedura.hiltplayground.framework.datasource.cache.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.melaniedura.hiltplayground.framework.datasource.cache.model.BlogCacheEntity

@Dao
interface BlogDao {

    @Insert
    suspend fun insert(blogEntity: BlogCacheEntity): Long

    @Query("SELECT * FROM blogs")
    suspend fun get(): List<BlogCacheEntity>

}