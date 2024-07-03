package com.ikmal.android_compose_pagination.core.di

import com.ikmal.android_compose_pagination.home.data.api.HomeApi
import com.ikmal.android_compose_pagination.home.data.repository.HomeRepository
import com.ikmal.android_compose_pagination.home.data.repository.HomeRepositoryImpl
import com.ikmal.android_compose_pagination.moviedetail.data.api.MovieDetailApi
import com.ikmal.android_compose_pagination.moviedetail.data.repository.MovieDetailRepository
import com.ikmal.android_compose_pagination.moviedetail.data.repository.MovieDetailRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideHomeRepository(homeApi: HomeApi): HomeRepository =
        HomeRepositoryImpl(homeApi = homeApi)

    @Provides
    @Singleton
    fun provideMovieDetailRepository(movieDetailApi: MovieDetailApi): MovieDetailRepository =
        MovieDetailRepositoryImpl(movieDetailApi = movieDetailApi)
}