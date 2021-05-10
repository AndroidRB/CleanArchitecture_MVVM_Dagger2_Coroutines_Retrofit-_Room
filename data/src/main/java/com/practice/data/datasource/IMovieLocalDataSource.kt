package com.practice.data.datasource

import com.practice.data.model.MovieEntity

interface IMovieLocalDataSource {
    suspend fun insertMovie(movieEntity: MovieEntity)
    suspend fun getAllMovies(): List<MovieEntity>
    suspend fun deleteMovie(movieId: Long)
}