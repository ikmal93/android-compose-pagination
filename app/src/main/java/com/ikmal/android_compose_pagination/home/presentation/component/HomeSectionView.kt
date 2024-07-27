package com.ikmal.android_compose_pagination.home.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.ikmal.android_compose_pagination.home.presentation.HomeState

@Composable
fun HomeSectionView(
    state: HomeState,
    title: String,
    onClickSeeMore: () -> Unit,
    onCardClick: (String) -> Unit
) {
    when (state) {
        is HomeState.Success -> {
            val data = state.data
            val list = data.results ?: emptyList()
            Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                HomeSectionTitleView(title = title) {
                    onClickSeeMore.invoke()
                }
                LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                    items(list.size) {
                        HomeSectionCardView(list[it]) { movieId ->
                            onCardClick.invoke(movieId)
                        }
                    }
                }
            }
        }

        else -> Unit

    }

}