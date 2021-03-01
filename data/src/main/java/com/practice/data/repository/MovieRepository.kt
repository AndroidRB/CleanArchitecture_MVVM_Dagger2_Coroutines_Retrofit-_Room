package com.practice.data.repository

import com.practice.data.source.MovieDataSource

class MovieRepository(private val dataSource: MovieDataSource) {
    suspend fun getPopularMovies(page: Int) = dataSource.getPopularMovies(page)
}