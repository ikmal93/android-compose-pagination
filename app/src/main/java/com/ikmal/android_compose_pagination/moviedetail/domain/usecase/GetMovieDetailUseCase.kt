package com.ikmal.android_compose_pagination.moviedetail.domain.usecase

import com.ikmal.android_compose_pagination.core.Result
import com.ikmal.android_compose_pagination.moviedetail.data.repository.MovieDetailRepository
import com.ikmal.android_compose_pagination.moviedetail.domain.model.MovieDetailEntity
import javax.inject.Inject

class GetMovieDetailUseCase @Inject constructor(
    private val movieDetailRepository: MovieDetailRepository
) {
    suspend fun execute(movieId: String): Result<MovieDetailEntity> {
        return try {
            Result.Loading
            val user = movieDetailRepository.getMovieDetail(movieId)
            Result.Success(user)
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}