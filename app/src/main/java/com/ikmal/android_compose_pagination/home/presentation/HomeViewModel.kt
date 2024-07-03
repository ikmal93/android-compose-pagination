package com.ikmal.android_compose_pagination.home.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ikmal.android_compose_pagination.home.domain.usecase.GetPopularMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.ikmal.android_compose_pagination.core.Result
import com.ikmal.android_compose_pagination.home.domain.model.PopularMoviesEntity
import com.ikmal.android_compose_pagination.home.domain.usecase.GetNowPlayingMoviesUseCase
import com.ikmal.android_compose_pagination.home.domain.usecase.GetTopRatedMoviesUseCase
import com.ikmal.android_compose_pagination.home.domain.usecase.GetUpcomingMoviesUseCase
import com.ikmal.android_compose_pagination.moviedetail.domain.model.MovieDetailEntity
import com.ikmal.android_compose_pagination.moviedetail.domain.usecase.GetMovieDetailUseCase

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase,
    private val getTopRatedMoviesUseCase: GetTopRatedMoviesUseCase,
    private val getNowPlayingMoviesUseCase: GetNowPlayingMoviesUseCase,
    private val getUpcomingMoviesUseCase: GetUpcomingMoviesUseCase,
) : ViewModel() {

    private val _popularMoviesState = mutableStateOf<Result<PopularMoviesEntity>>(Result.Loading)
    val popularMoviesState: State<Result<PopularMoviesEntity>> = _popularMoviesState

    private val _topRatedMoviesState = mutableStateOf<Result<PopularMoviesEntity>>(Result.Loading)
    val topRatedMoviesState: State<Result<PopularMoviesEntity>> = _topRatedMoviesState

    private val _nowPlayingMoviesState = mutableStateOf<Result<PopularMoviesEntity>>(Result.Loading)
    val nowPlayingMoviesState: State<Result<PopularMoviesEntity>> = _nowPlayingMoviesState

    private val _upcomingMoviesState = mutableStateOf<Result<PopularMoviesEntity>>(Result.Loading)
    val upcomingMoviesState: State<Result<PopularMoviesEntity>> = _upcomingMoviesState

    fun getPopularMovies() {
        viewModelScope.launch {
            when (val result = getPopularMoviesUseCase.execute()) {
                is Result.Loading -> {
                    _popularMoviesState.value = Result.Loading
                }

                is Result.Success -> {
                    _popularMoviesState.value = Result.Success(result.data)
                }

                is Result.Error -> {
                    _popularMoviesState.value = Result.Error(result.exception)
                }
            }
        }
    }

    fun getTopRatedMovies() {
        viewModelScope.launch {
            when (val result = getTopRatedMoviesUseCase.execute()) {
                is Result.Loading -> {
                    _topRatedMoviesState.value = Result.Loading
                }

                is Result.Success -> {
                    _topRatedMoviesState.value = Result.Success(result.data)
                }

                is Result.Error -> {
                    _topRatedMoviesState.value = Result.Error(result.exception)
                }
            }
        }
    }

    fun getNowPlayingMovies() {
        viewModelScope.launch {
            when (val result = getNowPlayingMoviesUseCase.execute()) {
                is Result.Loading -> {
                    _nowPlayingMoviesState.value = Result.Loading
                }

                is Result.Success -> {
                    _nowPlayingMoviesState.value = Result.Success(result.data)
                }

                is Result.Error -> {
                    _nowPlayingMoviesState.value = Result.Error(result.exception)
                }
            }
        }
    }

    fun getUpComingMovies() {
        viewModelScope.launch {
            when (val result = getUpcomingMoviesUseCase.execute()) {
                is Result.Loading -> {
                    _upcomingMoviesState.value = Result.Loading
                }

                is Result.Success -> {
                    _upcomingMoviesState.value = Result.Success(result.data)
                }

                is Result.Error -> {
                    _upcomingMoviesState.value = Result.Error(result.exception)
                }
            }
        }
    }
}