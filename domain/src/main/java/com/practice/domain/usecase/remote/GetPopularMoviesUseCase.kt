package com.practice.domain.usecase.remote

import com.practice.domain.repository.IMovieRemoteRepository

class GetPopularMoviesUseCase(
    private val repository: IMovieRemoteRepository
) {
    suspend operator fun invoke(page: Int) = repository.getPopularMovies(page)
}