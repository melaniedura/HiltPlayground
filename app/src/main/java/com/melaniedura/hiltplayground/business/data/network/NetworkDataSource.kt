package com.melaniedura.hiltplayground.business.data.network

import com.melaniedura.hiltplayground.business.domain.models.Blog

interface NetworkDataSource {
    suspend fun get(): List<Blog>
}