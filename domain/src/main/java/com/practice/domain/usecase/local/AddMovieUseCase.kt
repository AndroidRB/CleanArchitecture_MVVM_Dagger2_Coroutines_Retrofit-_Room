package com.practice.domain.usecase.local

import com.practice.domain.entity.Movie
import com.practice.domain.repository.IMovieLocalRepository

class AddMovieUseCase(
    private val repository: IMovieLocalRepository
) {
    suspend operator fun invoke(movie: Movie) = repository.insertMovie(movie)
}