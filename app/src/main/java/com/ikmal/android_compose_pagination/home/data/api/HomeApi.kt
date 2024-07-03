package com.ikmal.android_compose_pagination.home.data.api

import com.ikmal.android_compose_pagination.home.data.model.PopularMoviesResponse
import retrofit2.http.GET


interface HomeApi {
    @GET("movie/popular")
    suspend fun getPopularMovies(): PopularMoviesResponse
    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(): PopularMoviesResponse
    @GET("movie/now_playing")
    suspend fun getNowPlayingMovies(): PopularMoviesResponse
    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(): PopularMoviesResponse
}