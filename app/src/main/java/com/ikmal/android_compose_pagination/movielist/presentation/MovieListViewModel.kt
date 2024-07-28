package com.ikmal.android_compose_pagination.movielist.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ikmal.android_compose_pagination.core.Result
import com.ikmal.android_compose_pagination.core.presentation.ListState
import com.ikmal.android_compose_pagination.movielist.domain.model.MovieListEntity
import com.ikmal.android_compose_pagination.movielist.domain.usecase.GetMovieListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val getMovieListUseCase: GetMovieListUseCase
) : ViewModel() {

    val movies = mutableStateListOf<MovieListEntity.ResultEntity>()

    private var requestPage by mutableStateOf(1)
    private var previousPage by mutableStateOf(0)
    var listState by mutableStateOf(ListState.IDLE)

    init {
        getMovieList()
    }

    fun getMovieList(path: String = "popular") {
        if (previousPage != requestPage && listState == ListState.IDLE) {
            previousPage = requestPage
            viewModelScope.launch {
                when (val result = getMovieListUseCase.execute(path = path, page = requestPage)) {
                    is Result.Loading -> {
                        listState =
                            if (requestPage == 1) ListState.LOADING else ListState.PAGINATING
                    }

                    is Result.Success -> {
                        listState =
                            if (requestPage == 1) ListState.LOADING else ListState.PAGINATING
                        delay(1000)
                        val collections = result.data.results ?: mutableListOf()
                        if (requestPage == 1) {
                            movies.clear()
                            movies.addAll(collections)
                        } else {
                            movies.addAll(collections)
                        }
                        requestPage++
                        listState = ListState.IDLE
                    }

                    else -> Unit
                }
            }
        }
    }
}