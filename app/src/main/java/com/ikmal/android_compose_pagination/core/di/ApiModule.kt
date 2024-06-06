package com.ikmal.android_compose_pagination.core.di

import com.ikmal.android_compose_pagination.home.data.api.HomeApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {
    @Provides
    @Singleton
    fun provideHomeApi(
        retrofit: Retrofit
    ): HomeApi =
        retrofit.create(HomeApi::class.java)
}