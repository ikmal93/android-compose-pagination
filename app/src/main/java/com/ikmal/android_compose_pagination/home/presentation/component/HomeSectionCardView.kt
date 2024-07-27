package com.ikmal.android_compose_pagination.home.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.ikmal.android_compose_pagination.home.domain.model.ResultEntity

@Composable
fun HomeSectionCardView(data: ResultEntity, onCardClick: (String) -> Unit = {}) {
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