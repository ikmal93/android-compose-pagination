package com.ikmal.android_compose_pagination.movielist.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

fun NavGraphBuilder.movieListScreen() {
    composable("movie_list") {
        val viewModel = hiltViewModel<MovieListViewModel>()
        MovieListScreen(viewModel)
    }
}

@Composable
fun MovieListScreen(viewModel: MovieListViewModel) {
    val movieListState by viewModel.movieListState.collectAsState()
    Scaffold { innerPadding ->
        LazyColumn(
            contentPadding = innerPadding,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            when (movieListState) {
                is MovieListState.Success -> {
                    val data =
                        (movieListState as MovieListState.Success).data
                    data.results?.let { list ->
                        items(list.size) {
                            Text(
                                modifier = Modifier
                                    .padding(16.dp)
                                    .fillMaxWidth()
                                    .height(100.dp),
                                text = list[it].originalTitle.orEmpty()
                            )
                        }
                    }
                }

                else -> Unit
            }

        }
    }
}