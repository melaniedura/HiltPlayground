package com.melaniedura.hiltplayground.business.data.network

import com.melaniedura.hiltplayground.business.domain.models.Blog

class NetworkDataSourceImpl : NetworkDataSource {
    override suspend fun get(): List<Blog> {
        TODO("Not yet implemented")
    }
}