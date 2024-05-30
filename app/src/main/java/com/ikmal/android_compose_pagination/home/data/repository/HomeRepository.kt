package com.ikmal.android_compose_pagination.home.data.repository

import com.ikmal.android_compose_pagination.home.domain.model.PopularMoviesEntity

interface HomeRepository {
    suspend fun getPopularMovies(): PopularMoviesEntity
}