package com.melaniedura.hiltplayground.business.data.cache

import com.melaniedura.hiltplayground.business.domain.models.Blog

interface CacheDataSource {

    suspend fun insert(blog: Blog): Long

    suspend fun insertList(blogs: List<Blog>)

    suspend fun get(): List<Blog>
}