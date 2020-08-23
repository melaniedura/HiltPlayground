package com.melaniedura.hiltplayground.business.interactors

import com.melaniedura.hiltplayground.business.data.cache.CacheDataSource
import com.melaniedura.hiltplayground.business.data.network.NetworkDataSource
import com.melaniedura.hiltplayground.business.domain.DataState
import com.melaniedura.hiltplayground.business.domain.models.Blog
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetBlogs
constructor(
    private val cacheDataSource: CacheDataSource,
    private val networkDataSource: NetworkDataSource
){
    /**
     * Show loading
     * Get blogs from network
     * Insert blogs into cache
     * Show List<Blog>
     */
    suspend fun execute(): Flow<DataState<List<Blog>>> = flow {
        emit(DataState.Loading)
        delay(1000)
        val networkBlogs = networkDataSource.get()
        cacheDataSource.insertList(networkBlogs)
        val cachedBlogs = cacheDataSource.get()
        emit(DataState.Success(cachedBlogs))
    }
}