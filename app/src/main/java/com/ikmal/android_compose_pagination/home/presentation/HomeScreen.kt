package com.ikmal.android_compose_pagination.home.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ikmal.android_compose_pagination.core.Result
import com.ikmal.android_compose_pagination.home.domain.model.PopularMoviesEntity

@Composable
fun HomeScreen(viewModel: HomeViewModel = viewModel()) {
    val homeState by viewModel.homeState

    LaunchedEffect(Unit) {
        viewModel.getPopularMovies()
    }

    when (homeState) {
        is Result.Loading -> {
            LoadingIndicator()
        }

        is Result.Success -> {
            val data = (homeState as Result.Success<PopularMoviesEntity>).data
            val list = data.results ?: emptyList()
            LazyColumn(
                modifier = Modifier.padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(list.size) {
                    HomeItemList(list[it].title ?: "")
                }
            }
        }

        is Result.Error -> {}
    }

}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}

@Composable
fun HomeItemList(title: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(color = Color.White),
        shape = RoundedCornerShape(8.dp),
    ) {
        Text(text = title)
    }
}

@Composable
fun LoadingIndicator() {
//    CircularProgressIndicator()
}

@Preview
@Composable
fun HomeItemListPreview() {
    HomeItemList("AKA")
}