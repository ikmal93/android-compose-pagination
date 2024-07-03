package com.ikmal.android_compose_pagination.moviedetail.data.api

import com.ikmal.android_compose_pagination.moviedetail.data.model.MovieDetailResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieDetailApi {
    @GET("movie/{movie_id}")
    suspend fun getMovieDetail(
        @Path("movie_id") movieId: String,
    ): MovieDetailResponse
}