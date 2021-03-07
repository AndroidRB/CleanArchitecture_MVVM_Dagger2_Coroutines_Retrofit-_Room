package com.practice.domain.usecase.local

import com.practice.data.repository.MovieLocalRepository
import com.practice.domain.entity.Movie
import com.practice.domain.mapper.local.GetAllMoviesMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetAllMoviesUseCase(
    private val repository: MovieLocalRepository,
    private val mapper: GetAllMoviesMapper
) {
    suspend operator fun invoke(): List<Movie> = withContext(Dispatchers.IO) {
        return@withContext mapper.map(repository.getAllMovies())
    }
}