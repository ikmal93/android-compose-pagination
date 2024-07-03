package com.ikmal.android_compose_pagination.moviedetail.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ikmal.android_compose_pagination.core.Result
import com.ikmal.android_compose_pagination.moviedetail.domain.model.MovieDetailEntity
import com.ikmal.android_compose_pagination.moviedetail.domain.usecase.GetMovieDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val getMovieDetailUseCase: GetMovieDetailUseCase
) : ViewModel() {
    private val _movieDetailState = mutableStateOf<Result<MovieDetailEntity>>(Result.Loading)
    val movieDetailState: State<Result<MovieDetailEntity>> = _movieDetailState

    fun getPopularMovies(movieId: String) {
        viewModelScope.launch {
            when (val result = getMovieDetailUseCase.execute(movieId)) {
                is Result.Loading -> {
                    _movieDetailState.value = Result.Loading
                }

                is Result.Success -> {
                    _movieDetailState.value = Result.Success(result.data)
                }

                is Result.Error -> {
                    _movieDetailState.value = Result.Error(result.exception)
                }
            }
        }
    }
}