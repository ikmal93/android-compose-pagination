package com.ikmal.android_compose_pagination.movielist.data.api

import com.ikmal.android_compose_pagination.movielist.data.model.MovieListResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieListApi {
    @GET("movie/{path}")
    suspend fun getMovieList(
        @Path("path") path: String,
        @Query("page") page: Int,
    ): MovieListResponse
}