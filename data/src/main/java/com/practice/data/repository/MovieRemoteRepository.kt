package com.practice.data.repository

import com.practice.data.repository.source.MovieDataSource

class MovieRemoteRepository(
    private val dataSource: MovieDataSource
) {
    suspend fun getPopularMovies(page: Int) = dataSource.getPopularMovies(page)
}