package com.practice.domain.usecase.local

import com.practice.domain.model.MovieItem
import com.practice.domain.repository.IMovieLocalRepository

class GetAllMoviesUseCase(
    private val repository: IMovieLocalRepository
) {
    suspend operator fun invoke(): List<MovieItem> = repository.getAllMovies()
}