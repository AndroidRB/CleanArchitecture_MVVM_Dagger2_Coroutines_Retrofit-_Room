package com.practice.domain.usecase

import com.practice.data.repository.MovieRepository
import com.practice.domain.mapper.PopularMoviesListMapper

class GetPopularMoviesUseCase(
    private val repository: MovieRepository,
    private val popularMoviesListMapper: PopularMoviesListMapper
) {
    suspend operator fun invoke(page: Int) =
        popularMoviesListMapper.map(repository.getPopularMovies(page))
}