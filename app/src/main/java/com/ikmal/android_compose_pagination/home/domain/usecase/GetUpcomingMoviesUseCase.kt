package com.ikmal.android_compose_pagination.home.domain.usecase

import com.ikmal.android_compose_pagination.core.Result
import com.ikmal.android_compose_pagination.home.data.repository.HomeRepository
import com.ikmal.android_compose_pagination.home.domain.model.PopularMoviesEntity
import javax.inject.Inject

class GetUpcomingMoviesUseCase @Inject constructor(
    private val homeRepository: HomeRepository
) {
    suspend fun execute(): Result<PopularMoviesEntity> {
        return try {
            Result.Loading
            val user = homeRepository.getUpcomingMovies()
            Result.Success(user)
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}