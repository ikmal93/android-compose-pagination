package com.ikmal.android_compose_pagination.moviedetail.data.repository

import com.ikmal.android_compose_pagination.moviedetail.data.api.MovieDetailApi
import com.ikmal.android_compose_pagination.moviedetail.data.model.toEntity
import com.ikmal.android_compose_pagination.moviedetail.domain.model.MovieDetailEntity

class MovieDetailRepositoryImpl(
    private val movieDetailApi: MovieDetailApi,
) : MovieDetailRepository  {
    override suspend fun getMovieDetail(movieId: String): MovieDetailEntity {
        return movieDetailApi.getMovieDetail(movieId).toEntity()
    }
}