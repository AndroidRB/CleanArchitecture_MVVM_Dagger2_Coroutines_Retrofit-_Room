package com.practice.domain.repository

import com.practice.domain.entity.Movie


interface IMovieLocalRepository {
    suspend fun insertMovie(movie: Movie)
    suspend fun getAllMovies(): List<Movie>
    suspend fun deleteMovie(movieId: Long)
}