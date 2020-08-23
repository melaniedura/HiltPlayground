package com.melaniedura.hiltplayground.framework.datasource.network

import com.melaniedura.hiltplayground.business.domain.models.Blog
import retrofit2.http.GET

interface BlogService {

    @GET("blogs")
    suspend fun get(): List<Blog>
}