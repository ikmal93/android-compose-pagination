package com.ikmal.android_compose_pagination.moviedetail.data.model

import com.ikmal.android_compose_pagination.moviedetail.domain.model.BelongsToCollectionEntity
import com.ikmal.android_compose_pagination.moviedetail.domain.model.GenreEntity
import com.ikmal.android_compose_pagination.moviedetail.domain.model.MovieDetailEntity
import com.ikmal.android_compose_pagination.moviedetail.domain.model.ProductionCompanyEntity
import com.ikmal.android_compose_pagination.moviedetail.domain.model.ProductionCountryEntity
import com.ikmal.android_compose_pagination.moviedetail.domain.model.SpokenLanguageEntity

fun MovieDetailResponse.toEntity(): MovieDetailEntity {
    return MovieDetailEntity(
        adult = this.adult,
        backdropPath = this.backdropPath,
        belongsToCollection = this.belongsToCollection.toEntity(),
        budget = this.budget,
        genres = this.genres?.map {
            it.toEntity()
        },
        homepage = this.homepage,
        id = this.id,
        imdbId = this.imdbId,
        originCountry = this.originCountry,
        originalLanguage = this.originalLanguage,
        originalTitle = this.originalTitle,
        overview = this.overview,
        popularity = this.popularity,
        posterPath = this.posterPath,
        productionCompanies = this.productionCompanies?.map {
            it.toEntity()
        },
        productionCountries = this.productionCountries?.map {
            it.toEntity()
        },
        releaseDate = this.releaseDate,
        revenue = this.revenue,
        runtime = this.runtime,
        spokenLanguages = this.spokenLanguages?.map {
            it.toEntity()
        },
        status = this.status,
        tagline = this.tagline,
        title = this.title,
        video = this.video,
        voteAverage = this.voteAverage,
        voteCount = this.voteCount,
    )
}

fun BelongsToCollectionResponse.toEntity(): BelongsToCollectionEntity {
    return BelongsToCollectionEntity(
        id = this.id,
        name = this.name,
        posterPath = this.posterPath,
        backdropPath = this.backdropPath,
    )
}

fun GenreResponse.toEntity(): GenreEntity {
    return GenreEntity(
        id = this.id,
        name = this.name,
    )
}

fun ProductionCompanyResponse.toEntity(): ProductionCompanyEntity {
    return ProductionCompanyEntity(
        id = this.id,
        logoPath = this.logoPath,
        name = this.name,
        originCountry = this.originCountry,
    )
}

fun ProductionCountryResponse.toEntity(): ProductionCountryEntity {
    return ProductionCountryEntity(
        iso31661 = this.iso31661,
        name = this.name,
    )
}

fun SpokenLanguageResponse.toEntity(): SpokenLanguageEntity {
    return SpokenLanguageEntity(
        englishName = this.englishName,
        iso6391 = this.iso6391,
        name = this.name,
    )
}