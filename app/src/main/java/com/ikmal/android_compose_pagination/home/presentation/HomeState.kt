package com.ikmal.android_compose_pagination.home.presentation

import com.ikmal.android_compose_pagination.home.domain.model.PopularMoviesEntity

sealed class HomeState {
    data object Init : HomeState()
    data object Loading : HomeState()
    data class Success(val data: PopularMoviesEntity) : HomeState()
    data class Error(val exception: Exception) : HomeState()
}

