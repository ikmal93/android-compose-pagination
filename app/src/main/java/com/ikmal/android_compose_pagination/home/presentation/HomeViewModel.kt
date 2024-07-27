package com.ikmal.android_compose_pagination.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ikmal.android_compose_pagination.core.Result
import com.ikmal.android_compose_pagination.home.domain.usecase.GetNowPlayingMoviesUseCase
import com.ikmal.android_compose_pagination.home.domain.usecase.GetPopularMoviesUseCase
import com.ikmal.android_compose_pagination.home.domain.usecase.GetTopRatedMoviesUseCase
import com.ikmal.android_compose_pagination.home.domain.usecase.GetUpcomingMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase,
    private val getTopRatedMoviesUseCase: GetTopRatedMoviesUseCase,
    private val getNowPlayingMoviesUseCase: GetNowPlayingMoviesUseCase,
    private val getUpcomingMoviesUseCase: GetUpcomingMoviesUseCase,
) : ViewModel() {

    private val _popularMoviesState = MutableStateFlow<HomeState>(HomeState.Init)
    val popularMoviesState: MutableStateFlow<HomeState> = _popularMoviesState

    private val _topRatedMoviesState = MutableStateFlow<HomeState>(HomeState.Init)
    val topRatedMoviesState: MutableStateFlow<HomeState> = _topRatedMoviesState

    private val _nowPlayingMoviesState = MutableStateFlow<HomeState>(HomeState.Init)
    val nowPlayingMoviesState: MutableStateFlow<HomeState> = _nowPlayingMoviesState

    private val _upcomingMoviesState = MutableStateFlow<HomeState>(HomeState.Init)
    val upcomingMoviesState: MutableStateFlow<HomeState> = _upcomingMoviesState

    init {
        getPopularMovies()
        getTopRatedMovies()
        getNowPlayingMovies()
        getUpComingMovies()
    }

    fun getPopularMovies() {
        viewModelScope.launch {
            _popularMoviesState.emit(HomeState.Init)
            when (val result = getPopularMoviesUseCase.execute()) {
                is Result.Loading -> {
                    _popularMoviesState.update {
                        HomeState.Loading
                    }
                }

                is Result.Success -> {
                    _popularMoviesState.update {
                        HomeState.Success(result.data)
                    }
                }

                is Result.Error -> {
                    _popularMoviesState.update {
                        HomeState.Error(result.exception)
                    }
                }
            }
        }
    }

    fun getTopRatedMovies() {
        viewModelScope.launch {
            _topRatedMoviesState.emit(HomeState.Init)
            when (val result = getTopRatedMoviesUseCase.execute()) {
                is Result.Loading -> {
                    _topRatedMoviesState.update {
                        HomeState.Loading
                    }
                }

                is Result.Success -> {
                    _topRatedMoviesState.update {
                        HomeState.Success(result.data)
                    }
                }

                is Result.Error -> {
                    _topRatedMoviesState.update {
                        HomeState.Error(result.exception)
                    }
                }
            }
        }
    }

    fun getNowPlayingMovies() {
        viewModelScope.launch {
            _nowPlayingMoviesState.emit(HomeState.Init)
            when (val result = getNowPlayingMoviesUseCase.execute()) {
                is Result.Loading -> {
                    _nowPlayingMoviesState.update {
                        HomeState.Loading
                    }
                }

                is Result.Success -> {
                    _nowPlayingMoviesState.update {
                        HomeState.Success(result.data)
                    }
                }

                is Result.Error -> {
                    _nowPlayingMoviesState.update {
                        HomeState.Error(result.exception)
                    }
                }
            }
        }
    }

    fun getUpComingMovies() {
        viewModelScope.launch {
            _upcomingMoviesState.emit(HomeState.Init)
            when (val result = getUpcomingMoviesUseCase.execute()) {
                is Result.Loading -> {
                    _upcomingMoviesState.update {
                        HomeState.Loading
                    }
                }

                is Result.Success -> {
                    _upcomingMoviesState.update {
                        HomeState.Success(result.data)
                    }
                }

                is Result.Error -> {
                    _upcomingMoviesState.update {
                        HomeState.Error(result.exception)
                    }
                }
            }
        }
    }
}