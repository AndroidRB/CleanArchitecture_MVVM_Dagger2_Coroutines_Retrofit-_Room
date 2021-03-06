package com.practice.data.repository

import com.practice.data.repository.source.remote.MovieRemoteDataSource

class MovieRemoteRepository(
    private val remoteDataSource: MovieRemoteDataSource
) {
    suspend fun getPopularMovies(page: Int) = remoteDataSource.getPopularMovies(page)
}