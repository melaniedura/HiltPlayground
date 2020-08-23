package com.melaniedura.hiltplayground.di

import com.melaniedura.hiltplayground.repository.MainRepository
import com.melaniedura.hiltplayground.retrofit.BlogRetrofit
import com.melaniedura.hiltplayground.retrofit.NetworkMapper
import com.melaniedura.hiltplayground.room.BlogDao
import com.melaniedura.hiltplayground.room.CacheMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideMainRepository(
        blogDao: BlogDao,
        retrofit: BlogRetrofit,
        cacheMapper: CacheMapper,
        networkMapper: NetworkMapper
    ): MainRepository {
        return MainRepository(blogDao, retrofit, cacheMapper, networkMapper)
    }
}