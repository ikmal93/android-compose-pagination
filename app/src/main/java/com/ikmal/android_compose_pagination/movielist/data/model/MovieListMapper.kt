package com.ikmal.android_compose_pagination.movielist.data.model

import com.ikmal.android_compose_pagination.core.presentation.Constant
import com.ikmal.android_compose_pagination.movielist.domain.model.MovieListEntity

fun MovieListResponse.toEntity(): MovieListEntity {
    return MovieListEntity(
        page = this.page,
        results = this.results?.map {
            it.toEntity()
        },
        totalPages = this.totalPages,
        totalResults = this.totalResults,
    )
}

fun MovieListResponse.ResultResponse.toEntity(): MovieListEntity.ResultEntity {
    return MovieListEntity.ResultEntity(
        adult = this.adult,
        backdropPath = Constant.BASE_IMAGE_URL + this.backdropPath,
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