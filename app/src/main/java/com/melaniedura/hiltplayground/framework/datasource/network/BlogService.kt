package com.melaniedura.hiltplayground.framework.datasource.network

import com.melaniedura.hiltplayground.framework.datasource.network.model.BlogNetworkEntity
import retrofit2.http.GET

interface BlogService {

    @GET("blogs")
    suspend fun get(): List<BlogNetworkEntity>
}