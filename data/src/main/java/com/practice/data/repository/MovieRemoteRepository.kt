package com.practice.data.repository

import com.practice.data.datasource.IMovieRemoteDataSource
import com.practice.domain.repository.IMovieRemoteRepository

class MovieRemoteRepository(
    private val remoteDataSource: IMovieRemoteDataSource
) : IMovieRemoteRepository {

    override suspend fun getPopularMovies(page: Int) = remoteDataSource.getPopularMovies(page)
}