package com.practice.domain.usecase.local

import com.practice.domain.repository.IMovieLocalRepository

class RemoveMovieUseCase(
    private val repository: IMovieLocalRepository
) {
    suspend operator fun invoke(movieId: Long) =  repository.deleteMovie(movieId)
}