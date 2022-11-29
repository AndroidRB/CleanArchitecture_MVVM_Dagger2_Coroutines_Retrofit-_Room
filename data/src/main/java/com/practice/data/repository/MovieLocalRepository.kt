package com.practice.data.repository

import com.practice.data.datasource.contract.IMovieLocalDataSource
import com.practice.domain.entity.Movie
import com.practice.domain.repository.IMovieLocalRepository

class MovieLocalRepository(
    private val localDataSource: IMovieLocalDataSource
) : IMovieLocalRepository{
    override suspend fun insertMovie(movie: Movie) = localDataSource.insertMovie(movie)

    override suspend fun getAllMovies() = localDataSource.getAllMovies()

    override suspend fun deleteMovie(movieId: Long) = localDataSource.deleteMovie(movieId)
}