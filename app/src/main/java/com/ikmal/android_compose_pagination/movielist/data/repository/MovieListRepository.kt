package com.ikmal.android_compose_pagination.movielist.data.repository

import com.ikmal.android_compose_pagination.movielist.domain.model.MovieListEntity

interface MovieListRepository {
    suspend fun getMovieList(
        path: String, page: Int,
    ): MovieListEntity
}