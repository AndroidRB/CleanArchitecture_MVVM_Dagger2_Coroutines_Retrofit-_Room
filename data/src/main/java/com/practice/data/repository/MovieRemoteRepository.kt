package com.practice.data.repository

import com.practice.data.datasource.contract.IMovieRemoteDataSource
import com.practice.domain.repository.IMovieRemoteRepository

class MovieRemoteRepository(
    private val remoteDataSource: IMovieRemoteDataSource
) : IMovieRemoteRepository {

    override suspend fun getPopularMovies(page: Int) = remoteDataSource.getPopularMovies(page)
}