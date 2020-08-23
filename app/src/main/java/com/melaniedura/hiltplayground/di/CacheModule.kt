package com.melaniedura.hiltplayground.di

import androidx.room.Room
import com.melaniedura.hiltplayground.business.data.cache.CacheDataSource
import com.melaniedura.hiltplayground.business.data.cache.CacheDataSourceImpl
import com.melaniedura.hiltplayground.business.domain.models.Blog
import com.melaniedura.hiltplayground.business.domain.util.EntityMapper
import com.melaniedura.hiltplayground.framework.datasource.cache.database.BlogDao
import com.melaniedura.hiltplayground.framework.datasource.cache.database.BlogDatabase
import com.melaniedura.hiltplayground.framework.datasource.cache.mappers.CacheMapper
import com.melaniedura.hiltplayground.framework.datasource.cache.model.BlogCacheEntity
import com.melaniedura.hiltplayground.framework.presentation.MyApplication
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object CacheModule {

    @Singleton
    @Provides
    fun provideCacheMapper(): EntityMapper<BlogCacheEntity, Blog> {
        return CacheMapper()
    }

    @Singleton
    @Provides
    fun provideNoteDb(app: MyApplication): BlogDatabase {
        return Room
            .databaseBuilder(app, BlogDatabase::class.java, BlogDatabase.DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideBlogDAO(blogDatabase: BlogDatabase): BlogDao {
        return blogDatabase.blogDao()
    }

    @Singleton
    @Provides
    fun provideCacheDataSource(): CacheDataSource {
        return CacheDataSourceImpl()
    }

}