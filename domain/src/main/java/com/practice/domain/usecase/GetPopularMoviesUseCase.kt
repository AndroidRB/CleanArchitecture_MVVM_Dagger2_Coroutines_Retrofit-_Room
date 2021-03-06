package com.practice.domain.usecase

import com.practice.data.repository.MovieRemoteRepository
import com.practice.domain.mapper.PopularMoviesListMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetPopularMoviesUseCase(
    private val repository: MovieRemoteRepository,
    private val popularMoviesListMapper: PopularMoviesListMapper
) {
    suspend operator fun invoke(page: Int) = withContext(Dispatchers.IO) {
       return@withContext popularMoviesListMapper.map(repository.getPopularMovies(page))
    }
}