package com.ikmal.android_compose_pagination.home.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.ikmal.android_compose_pagination.core.Result
import com.ikmal.android_compose_pagination.home.domain.model.PopularMoviesEntity
import com.ikmal.android_compose_pagination.home.domain.model.ResultEntity
import com.ikmal.android_compose_pagination.moviedetail.presentation.MovieDetailScreen
import com.ikmal.android_compose_pagination.moviedetail.presentation.MovieDetailViewModel

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
    val popularMoviesState by homeViewModel.popularMoviesState
    val topRatedMoviesState by homeViewModel.topRatedMoviesState
    val nowPlayingMoviesState by homeViewModel.nowPlayingMoviesState
    val upcomingMoviesState by homeViewModel.upcomingMoviesState

    LaunchedEffect(Unit) {
        homeViewModel.getPopularMovies()
        homeViewModel.getTopRatedMovies()
        homeViewModel.getNowPlayingMovies()
        homeViewModel.getUpComingMovies()
    }

    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "Popular Movies",
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.SemiBold,
                fontSize = 24.sp,
                color = Color.Black
            )
        }
        item {
            when (popularMoviesState) {
                is Result.Loading -> {
                    LoadingIndicator()
                }

                is Result.Success -> {
                    val data =
                        (popularMoviesState as Result.Success<PopularMoviesEntity>).data
                    val list = data.results ?: emptyList()
                    LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                        items(list.size) {
                            HomeItemList(list[it]) {
                                navController.navigate("detail/$it")
                            }
                        }
                    }
                }

                is Result.Error -> {}
            }

        }
        item {
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "Top Rated",
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.SemiBold,
                fontSize = 24.sp,
                color = Color.Black
            )
        }
        item {
            when (topRatedMoviesState) {
                is Result.Loading -> {
                    LoadingIndicator()
                }

                is Result.Success -> {
                    val data =
                        (topRatedMoviesState as Result.Success<PopularMoviesEntity>).data
                    val list = data.results ?: emptyList()
                    LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                        items(list.size) {
                            HomeItemList(list[it]) {
                                navController.navigate("detail/$it")
                            }
                        }
                    }
                }

                is Result.Error -> {}
            }

        }
        item {
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "Now Playing",
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.SemiBold,
                fontSize = 24.sp,
                color = Color.Black
            )
        }
        item {
            when (nowPlayingMoviesState) {
                is Result.Loading -> {
                    LoadingIndicator()
                }

                is Result.Success -> {
                    val data =
                        (nowPlayingMoviesState as Result.Success<PopularMoviesEntity>).data
                    val list = data.results ?: emptyList()
                    LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                        items(list.size) {
                            HomeItemList(list[it]) {
                                navController.navigate("detail/$it")
                            }
                        }
                    }
                }

                is Result.Error -> {}
            }

        }
        item {
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "Upcoming",
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.SemiBold,
                fontSize = 24.sp,
                color = Color.Black
            )
        }
        item {
            when (upcomingMoviesState) {
                is Result.Loading -> {
                    LoadingIndicator()
                }

                is Result.Success -> {
                    val data =
                        (upcomingMoviesState as Result.Success<PopularMoviesEntity>).data
                    val list = data.results ?: emptyList()
                    LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                        items(list.size) {
                            HomeItemList(list[it]) {
                                navController.navigate("detail/$it")
                            }
                        }
                    }
                }

                is Result.Error -> {}
            }

        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
//    HomeScreen()
}

@Composable
fun HomeItemList(data: ResultEntity, onCardClick: (String) -> Unit = {}) {
    Card(
        modifier = Modifier
            .width(250.dp)
            .height(250.dp)
            .background(color = Color.White)
            .clickable {
                onCardClick.invoke(data.id.toString())
            },
        shape = RoundedCornerShape(8.dp),
    ) {
        Box {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = rememberAsyncImagePainter(model = data.backdropPath),
                contentDescription = "none",
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(75.dp)
                    .align(alignment = Alignment.BottomStart)
                    .padding(16.dp),
            ) {
                Text(
                    modifier = Modifier.fillMaxSize(),
                    text = data.title.orEmpty(),
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                    color = Color.White
                )
            }
        }
    }
}

@Composable
fun LoadingIndicator() {
//    CircularProgressIndicator()
}

@Preview
@Composable
fun HomeItemListPreview() {
//    HomeItemList(ResultEntity(()))
}