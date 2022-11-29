package com.practice.data.datasource.contract

import com.practice.domain.entity.Movie


interface IMovieRemoteDataSource {
    suspend fun getPopularMovies(page: Int): List<Movie>
}