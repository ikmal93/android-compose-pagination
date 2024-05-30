package com.ikmal.android_compose_pagination.home.data.model

import com.ikmal.android_compose_pagination.home.domain.model.PopularMoviesEntity
import com.ikmal.android_compose_pagination.home.domain.model.ResultEntity

fun PopularMoviesResponse.toEntity(): PopularMoviesEntity {
    return PopularMoviesEntity(
        page = this.page,
        results = this.results?.map {
            it.toEntity()
        },
        totalPages = this.totalPages,
        totalResults = this.totalResults,
    )
}

fun PopularMoviesResponse.ResultResponse.toEntity(): ResultEntity {
    return ResultEntity(
        adult = this.adult,
        backdropPath = this.backdropPath,
        genreIds = this.genreIds,
        id = this.id,
        originalLanguage = this.originalLanguage,
        originalTitle = this.originalTitle,
        overview = this.overview,
        popularity = this.popularity,
        posterPath = this.posterPath,
        releaseDate = this.releaseDate,
        title = this.title,
        video = this.video,
        voteAverage = this.voteAverage,
        voteCount = this.voteCount,
    )
}