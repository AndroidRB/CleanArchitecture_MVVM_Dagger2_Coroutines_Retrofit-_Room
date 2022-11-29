package com.practice.data.datasource.contract

import com.practice.domain.entity.Movie


interface IMovieLocalDataSource {
    suspend fun insertMovie(movie: Movie)
    suspend fun getAllMovies(): List<Movie>
    suspend fun deleteMovie(movieId: Long)
}