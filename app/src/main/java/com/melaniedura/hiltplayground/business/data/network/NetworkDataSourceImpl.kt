package com.melaniedura.hiltplayground.business.data.network

import com.melaniedura.hiltplayground.business.domain.models.Blog
import com.melaniedura.hiltplayground.framework.datasource.network.BlogService
import com.melaniedura.hiltplayground.framework.datasource.network.mappers.NetworkMapper
import javax.inject.Inject

class NetworkDataSourceImpl
    @Inject constructor(
        private val blogService: BlogService,
        private val networkMapper: NetworkMapper
    ): NetworkDataSource {
    override suspend fun get(): List<Blog> {
        return networkMapper.mapFromEntityList(blogService.get())
    }
}