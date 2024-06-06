package com.ikmal.android_compose_pagination.home.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.ikmal.android_compose_pagination.core.Result
import com.ikmal.android_compose_pagination.home.domain.model.PopularMoviesEntity
import com.ikmal.android_compose_pagination.home.domain.model.ResultEntity

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
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(list.size) {
                    HomeItemList(list[it])
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
fun HomeItemList(data: ResultEntity) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
            .background(color = Color.White),
        shape = RoundedCornerShape(8.dp),
    ) {
        Box {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = rememberAsyncImagePainter(model = data.backdropPath),
                contentDescription = "none",
                contentScale = ContentScale.Crop
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(alignment = Alignment.BottomStart)
                    .padding(16.dp),
                text = data.title.orEmpty(),
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.SemiBold,
                fontSize = 24.sp,
                color = Color.White
            )
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