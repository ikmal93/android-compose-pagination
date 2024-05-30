package com.ikmal.android_compose_pagination.home.data.repository

import com.ikmal.android_compose_pagination.home.data.api.HomeApi
import com.ikmal.android_compose_pagination.home.data.model.toEntity
import com.ikmal.android_compose_pagination.home.domain.model.PopularMoviesEntity

class HomeRepositoryImpl(
    private val homeApi: HomeApi,
) : HomeRepository {
    override suspend fun getPopularMovies(): PopularMoviesEntity {
        return homeApi.getPopularMovies().toEntity()
    }
}