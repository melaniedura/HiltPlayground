package com.melaniedura.hiltplayground.business.data.cache

import com.melaniedura.hiltplayground.business.domain.models.Blog
import com.melaniedura.hiltplayground.framework.datasource.cache.database.BlogDao
import com.melaniedura.hiltplayground.framework.datasource.cache.mappers.CacheMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CacheDataSourceImpl
constructor(
    private val blogDao: BlogDao,
    private val cacheMapper: CacheMapper
) : CacheDataSource {
    override suspend fun insert(blog: Blog): Long {
        return blogDao.insert(cacheMapper.mapToEntity(blog))
    }

    override suspend fun insertList(blogs: List<Blog>) = withContext(Dispatchers.IO) {
        for (blog in blogs) {
            blogDao.insert(cacheMapper.mapToEntity(blog))
        }
    }

    override suspend fun get(): List<Blog> {
        return cacheMapper.mapFromEntityList(blogDao.get())
    }
}