package com.practice.data.datasource

import com.practice.domain.model.Movie

interface IMovieRemoteDataSource {
    suspend fun getPopularMovies(page: Int): List<Movie>
}