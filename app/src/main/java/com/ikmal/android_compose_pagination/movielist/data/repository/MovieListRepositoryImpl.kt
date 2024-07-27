package com.ikmal.android_compose_pagination.movielist.data.repository

import com.ikmal.android_compose_pagination.movielist.data.api.MovieListApi
import com.ikmal.android_compose_pagination.movielist.data.model.toEntity
import com.ikmal.android_compose_pagination.movielist.domain.model.MovieListEntity

class MovieListRepositoryImpl(
    private val movieListApi: MovieListApi
) : MovieListRepository {
    override suspend fun getMovieList(path: String, page: Int): MovieListEntity {
        return movieListApi.getMovieList(path, page).toEntity()
    }
}