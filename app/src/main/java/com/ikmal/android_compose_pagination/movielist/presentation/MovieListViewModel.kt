package com.ikmal.android_compose_pagination.movielist.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ikmal.android_compose_pagination.core.Result
import com.ikmal.android_compose_pagination.movielist.domain.usecase.GetMovieListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val getMovieListUseCase: GetMovieListUseCase
) : ViewModel() {
    private val _movieListState = MutableStateFlow<MovieListState>(MovieListState.Init)
    val movieListState: MutableStateFlow<MovieListState> = _movieListState

    init {
        getMovieList("popular", 1)
    }

    fun getMovieList(path: String, page: Int){
        viewModelScope.launch {
            _movieListState.emit(MovieListState.Init)
            when(val result = getMovieListUseCase.execute(path = path, page = page)){
                is Result.Loading -> {
                    _movieListState.update {
                        MovieListState.Loading
                    }
                }

                is Result.Success -> {
                    _movieListState.update {
                        MovieListState.Success(result.data)
                    }
                }

                is Result.Error -> {
                    _movieListState.update {
                        MovieListState.Error(result.exception)
                    }
                }
            }
        }
    }
}