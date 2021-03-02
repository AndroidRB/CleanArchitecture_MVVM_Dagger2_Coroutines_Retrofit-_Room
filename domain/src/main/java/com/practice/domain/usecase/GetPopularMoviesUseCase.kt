package com.practice.domain.usecase

import com.practice.data.repository.MovieRemoteRepository
import com.practice.domain.mapper.PopularMoviesListMapper

class GetPopularMoviesUseCase(
    private val repository: MovieRemoteRepository,
    private val popularMoviesListMapper: PopularMoviesListMapper
) {
    suspend operator fun invoke(page: Int) =
        popularMoviesListMapper.map(repository.getPopularMovies(page))
}