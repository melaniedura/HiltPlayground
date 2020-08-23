package com.melaniedura.hiltplayground.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.melaniedura.hiltplayground.business.data.network.NetworkDataSource
import com.melaniedura.hiltplayground.business.data.network.NetworkDataSourceImpl
import com.melaniedura.hiltplayground.framework.datasource.network.BlogService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideGsonBuilder(): Gson {
        return GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create()
    }

    @Singleton
    @Provides
    fun provideRetrofit(gson:  Gson): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl("https://open-api.xyz/placeholder")
            .addConverterFactory(GsonConverterFactory.create(gson))
    }

    @Singleton
    @Provides
    fun provideBlogService(retrofit: Retrofit.Builder): BlogService {
        return retrofit
            .build()
            .create(BlogService::class.java)
    }

    @Singleton
    @Provides
    fun provideNetworkDataSource(): NetworkDataSource {
        return NetworkDataSourceImpl()
    }

}