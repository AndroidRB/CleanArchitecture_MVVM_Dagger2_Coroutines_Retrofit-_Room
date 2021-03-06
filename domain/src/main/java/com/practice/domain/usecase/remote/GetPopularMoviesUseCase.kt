package com.practice.domain.usecase.remote

import com.practice.data.repository.MovieRemoteRepository
import com.practice.domain.mapper.remote.PopularMoviesListMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetPopularMoviesUseCase(
    private val repository: MovieRemoteRepository,
    private val popularMoviesListMapper: PopularMoviesListMapper
) {
    suspend operator fun invoke(page: Int) = withContext(Dispatchers.IO) {
       return@withContext popularMoviesListMapper.map(repository.getPopularMovies(page))
    }
}