package com.practice.data.datasource.local

import com.practice.data.db.entity.MovieEntity

interface IMovieLocalDataSource {
    suspend fun insertMovie(movie: MovieEntity)
    suspend fun getAllMovies(): List<MovieEntity>
    suspend fun deleteMovie(movieId: Long)
}