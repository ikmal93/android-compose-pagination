package com.ikmal.android_compose_pagination.home.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.ikmal.android_compose_pagination.home.presentation.component.HomeSectionView

fun NavGraphBuilder.homeScreen(navController: NavController) {
    composable("home") {
        val homeViewModel = hiltViewModel<HomeViewModel>()
        HomeScreen(homeViewModel = homeViewModel, navController = navController)
    }
}

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = viewModel(),
    navController: NavController
) {
    val popularMoviesState by homeViewModel.popularMoviesState.collectAsState()
    val topRatedMoviesState by homeViewModel.topRatedMoviesState.collectAsState()
    val nowPlayingMoviesState by homeViewModel.nowPlayingMoviesState.collectAsState()
    val upcomingMoviesState by homeViewModel.upcomingMoviesState.collectAsState()

    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            HomeSectionView(
                state = popularMoviesState,
                title = "Popular Movies",
                onClickSeeMore = {
                    navController.navigate("movie_list")
                },
                onCardClick = {
                    navController.navigate("detail/$it")
                }
            )

        }
        item {
            HomeSectionView(
                state = topRatedMoviesState,
                title = "Top Rated",
                onClickSeeMore = {
                    navController.navigate("movie_list")
                },
                onCardClick = {
                    navController.navigate("detail/$it")
                }
            )
        }
        item {
            HomeSectionView(
                state = nowPlayingMoviesState,
                title = "Now Playing",
                onClickSeeMore = {
                    navController.navigate("movie_list")
                },
                onCardClick = {
                    navController.navigate("detail/$it")
                }
            )

        }
        item {
            HomeSectionView(
                state = upcomingMoviesState,
                title = "Upcoming",
                onClickSeeMore = {
                    navController.navigate("movie_list")
                },
                onCardClick = {
                    navController.navigate("detail/$it")
                }
            )
        }
    }
}