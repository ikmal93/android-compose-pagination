package com.ikmal.android_compose_pagination.movielist.domain.model

data class MovieListEntity(
    val page: Int?,
    val results: List<ResultEntity>?,
    val totalPages: Int?,
    val totalResults: Int?,
) {
    data class ResultEntity(
        val adult: Boolean?,
        val backdropPath: String?,
        val genreIds: List<Int>?,
        val id: Int?,
        val originalLanguage: String?,
        val originalTitle: String?,
        val overview: String?,
        val popularity: Double?,
        val posterPath: String?,
        val releaseDate: String?,
        val title: String?,
        val video: Boolean?,
        val voteAverage: Double?,
        val voteCount: Int?,
    )
}

