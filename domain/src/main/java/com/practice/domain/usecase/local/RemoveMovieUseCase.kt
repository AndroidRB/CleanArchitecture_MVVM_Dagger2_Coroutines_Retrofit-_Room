package com.practice.domain.usecase.local

import com.practice.data.repository.MovieLocalRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RemoveMovieUseCase(
    private val repository: MovieLocalRepository
) {
    suspend operator fun invoke(movieId: Long) =  repository.removeMovie(movieId)
}