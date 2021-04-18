package com.practice.data.repository

import com.practice.data.repository.mapper.local.AddMovieMapper
import com.practice.data.repository.mapper.local.GetAllMoviesMapper
import com.practice.data.datasource.local.IMovieLocalDataSource
import com.practice.domain.usecase.data.MovieItem
import com.practice.domain.repository.IMovieLocalRepository

class MovieLocalRepository(
    private val localDataSource: IMovieLocalDataSource,
    private val addMovieMapper: AddMovieMapper,
    private val getAllMoviesMapper: GetAllMoviesMapper
) : IMovieLocalRepository{
    override suspend fun insertMovie(movieItem: MovieItem) = localDataSource.insertMovie(addMovieMapper.map(movieItem))

    override suspend fun getAllMovies() = getAllMoviesMapper.map(localDataSource.getAllMovies())

    override suspend fun deleteMovie(movieId: Long) = localDataSource.deleteMovie(movieId)
}