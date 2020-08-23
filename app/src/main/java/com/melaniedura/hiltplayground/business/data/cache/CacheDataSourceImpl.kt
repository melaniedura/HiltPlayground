package com.melaniedura.hiltplayground.business.data.cache

import com.melaniedura.hiltplayground.business.domain.models.Blog

class CacheDataSourceImpl : CacheDataSource {
    override suspend fun insert(blog: Blog): Long {
        TODO("Not yet implemented")
    }

    override suspend fun insertList(blogs: List<Blog>) {
        TODO("Not yet implemented")
    }

    override suspend fun get(): List<Blog> {
        TODO("Not yet implemented")
    }
}