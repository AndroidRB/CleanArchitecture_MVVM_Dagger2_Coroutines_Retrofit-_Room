package com.practice.domain.usecase.local

import com.practice.domain.model.Movie
import com.practice.domain.repository.IMovieLocalRepository

class AddMovieUseCase(
    private val repository: IMovieLocalRepository
) {
    suspend operator fun invoke(movieItem: Movie) = repository.insertMovie(movieItem)
}