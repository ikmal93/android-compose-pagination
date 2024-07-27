package com.ikmal.android_compose_pagination.movielist.presentation

import com.ikmal.android_compose_pagination.home.domain.model.PopularMoviesEntity
import com.ikmal.android_compose_pagination.movielist.domain.model.MovieListEntity

sealed class MovieListState {
    data object Init : MovieListState()
    data object Loading : MovieListState()
    data class Success(val data: MovieListEntity) : MovieListState()
    data class Error(val exception: Exception) : MovieListState()
}