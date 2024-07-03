package com.ikmal.android_compose_pagination.moviedetail.data.repository

import com.ikmal.android_compose_pagination.moviedetail.domain.model.MovieDetailEntity

interface MovieDetailRepository {
    suspend fun getMovieDetail(movieId: String): MovieDetailEntity
}