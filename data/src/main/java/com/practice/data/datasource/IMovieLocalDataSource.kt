package com.practice.data.datasource

import com.practice.data.model.Movie

interface IMovieLocalDataSource {
    suspend fun insertMovie(movie: Movie)
    suspend fun getAllMovies(): List<Movie>
    suspend fun deleteMovie(movieId: Long)
}