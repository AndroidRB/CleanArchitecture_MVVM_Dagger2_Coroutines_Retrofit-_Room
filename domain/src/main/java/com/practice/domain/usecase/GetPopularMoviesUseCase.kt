package com.practice.domain.usecase

import com.practice.data.repository.MovieRepository

class GetPopularMoviesUseCase(private val repository: MovieRepository) {
    suspend operator fun invoke(page: Int) = repository.getPopularMovies(page)
}