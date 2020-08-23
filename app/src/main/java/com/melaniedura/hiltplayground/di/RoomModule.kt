package com.melaniedura.hiltplayground.di

import android.content.Context
import androidx.room.Room
import com.melaniedura.hiltplayground.model.Blog
import com.melaniedura.hiltplayground.room.BlogCacheEntity
import com.melaniedura.hiltplayground.room.BlogDao
import com.melaniedura.hiltplayground.room.BlogDatabase
import com.melaniedura.hiltplayground.room.CacheMapper
import com.melaniedura.hiltplayground.util.EntityMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)

object RoomModule {

    @Singleton
    @Provides
    fun provideBlogDb(@ApplicationContext context: Context): BlogDatabase {
        return Room
            .databaseBuilder(
                context,
                BlogDatabase::class.java,
                BlogDatabase.DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideBlogDAO(blogDatabase: BlogDatabase): BlogDao {
        return blogDatabase.blogDao()
    }

}