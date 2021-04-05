package com.practice.domain.repository

import com.practice.domain.usecase.data.MovieItem


interface IMovieLocalRepository {
    suspend fun insertMovie(movieItem: MovieItem)
    suspend fun getAllMovies(): List<MovieItem>
    suspend fun deleteMovie(movieId: Long)
}