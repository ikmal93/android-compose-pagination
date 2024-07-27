package com.ikmal.android_compose_pagination.moviedetail.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.ikmal.android_compose_pagination.core.Result
import com.ikmal.android_compose_pagination.moviedetail.domain.model.MovieDetailEntity

fun NavGraphBuilder.movieDetailScreen(navController: NavController) {
    composable("detail/{movieId}") {
        val homeViewModel = hiltViewModel<MovieDetailViewModel>()
        val movieId = it.arguments?.getString("movieId")
        MovieDetailScreen(movieId = movieId ?: "", homeViewModel)
    }
}

@Composable
fun MovieDetailScreen(movieId: String, viewModel: MovieDetailViewModel) {
    val movieDetailState by viewModel.movieDetailState

    LaunchedEffect(Unit) {
        viewModel.getPopularMovies(movieId)
    }
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            when (movieDetailState) {
                is Result.Success -> {
                    val data =
                        (movieDetailState as Result.Success<MovieDetailEntity>).data
                    Text(text = data.originalTitle ?: "")
                }

                else -> Unit
            }

        }
    }
}