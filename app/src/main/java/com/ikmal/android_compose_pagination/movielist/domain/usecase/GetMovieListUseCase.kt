package com.ikmal.android_compose_pagination.movielist.domain.usecase

import com.ikmal.android_compose_pagination.core.Result
import com.ikmal.android_compose_pagination.movielist.data.repository.MovieListRepository
import com.ikmal.android_compose_pagination.movielist.domain.model.MovieListEntity
import javax.inject.Inject

class GetMovieListUseCase @Inject constructor(
    private val movieListRepository: MovieListRepository
) {
    suspend fun execute(path: String, page: Int): Result<MovieListEntity> {
        return try {
            Result.Loading
            val user = movieListRepository.getMovieList(path, page)
            Result.Success(user)
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}