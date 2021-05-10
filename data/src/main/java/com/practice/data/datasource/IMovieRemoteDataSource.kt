package com.practice.data.datasource

import com.practice.data.model.MovieEntity

interface IMovieRemoteDataSource {
    suspend fun getPopularMovies(page: Int): List<MovieEntity>
}