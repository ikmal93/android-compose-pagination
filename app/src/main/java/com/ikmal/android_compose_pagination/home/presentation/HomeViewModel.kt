package com.ikmal.android_compose_pagination.home.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ikmal.android_compose_pagination.home.domain.usecase.GetPopularMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.ikmal.android_compose_pagination.core.Result
import com.ikmal.android_compose_pagination.home.domain.model.PopularMoviesEntity
import kotlinx.coroutines.flow.update

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase
) : ViewModel() {
//    private val _homeState: MutableStateFlow<HomeState> =
//        MutableStateFlow(HomeState.Loading)
//    val homeState: StateFlow<HomeState> =
//        _homeState

    private val _homeState = mutableStateOf<Result<PopularMoviesEntity>>(Result.Loading)
    val homeState: State<Result<PopularMoviesEntity>> = _homeState

    fun getPopularMovies() {
        viewModelScope.launch {
            when (val result = getPopularMoviesUseCase.execute()) {
                is Result.Loading -> {
                    _homeState.value = Result.Loading
                }

                is Result.Success -> {
                    _homeState.value = Result.Success(result.data)
                }

                is Result.Error -> {
                    _homeState.value = Result.Error(result.exception)
                }
            }
        }
    }
}