package com.melaniedura.hiltplayground.di

import com.melaniedura.hiltplayground.business.data.cache.CacheDataSource
import com.melaniedura.hiltplayground.business.data.network.NetworkDataSource
import com.melaniedura.hiltplayground.business.interactors.GetBlogs
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object InteractorsModule {

    @Singleton
    @Provides
    fun provideGetBlogs(
        cacheDataSource: CacheDataSource,
        networkDataSource: NetworkDataSource
    ): GetBlogs {
        return GetBlogs(cacheDataSource, networkDataSource)
    }
}