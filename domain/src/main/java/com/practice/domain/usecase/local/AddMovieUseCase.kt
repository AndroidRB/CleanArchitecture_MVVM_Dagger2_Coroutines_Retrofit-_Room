package com.practice.domain.usecase.local

import com.practice.data.repository.MovieLocalRepository
import com.practice.domain.entity.Movie
import com.practice.domain.mapper.local.AddMovieMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AddMovieUseCase(
    private val repository: MovieLocalRepository,
    private val mapper: AddMovieMapper
) {
    suspend operator fun invoke(movie: Movie) = withContext(Dispatchers.IO) {
        return@withContext repository.addMovie(mapper.map(movie))
    }
}