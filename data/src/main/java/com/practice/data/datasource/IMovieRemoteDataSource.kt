package com.practice.data.datasource

import com.practice.data.model.Movie

interface IMovieRemoteDataSource {
    suspend fun getPopularMovies(page: Int): List<Movie>
}