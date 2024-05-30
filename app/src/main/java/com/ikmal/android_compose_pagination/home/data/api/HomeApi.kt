package com.ikmal.android_compose_pagination.home.data.api

import com.ikmal.android_compose_pagination.home.data.model.PopularMoviesResponse
import retrofit2.http.GET


interface HomeApi {
    @GET("movie/popular")
    suspend fun getPopularMovies(): PopularMoviesResponse
}