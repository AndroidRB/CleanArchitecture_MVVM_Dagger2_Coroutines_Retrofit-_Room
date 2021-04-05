package com.practice.domain.usecase.local

import com.practice.domain.usecase.data.MovieItem
import com.practice.domain.repository.IMovieLocalRepository

class AddMovieUseCase(
    private val repository: IMovieLocalRepository
) {
    suspend operator fun invoke(movieItem: MovieItem) = repository.insertMovie(movieItem)
}