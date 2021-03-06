package com.practice.data.repository.source.local

import com.practice.data.db.entity.MovieEntity

interface MovieLocalDataSource {
    suspend fun insertMovie(movie: MovieEntity)
    suspend fun getAllMovies(): List<MovieEntity>
    suspend fun deleteMovie(movieId: Long)
}