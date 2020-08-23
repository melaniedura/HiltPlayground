package com.melaniedura.hiltplayground.business.interactors

import com.melaniedura.hiltplayground.business.data.cache.CacheDataSource
import com.melaniedura.hiltplayground.business.data.network.NetworkDataSource
import javax.inject.Inject

class GetBlogs
@Inject
constructor(
    private val cacheDataSource: CacheDataSource,
    private val networkDataSource: NetworkDataSource
){
    fun execute() {

    }
}