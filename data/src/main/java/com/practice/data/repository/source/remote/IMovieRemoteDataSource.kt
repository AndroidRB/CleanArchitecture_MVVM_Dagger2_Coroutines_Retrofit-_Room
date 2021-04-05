package com.practice.data.repository.source.remote

import com.practice.data.api.model.MovieListResponse

interface IMovieRemoteDataSource {
    suspend fun getPopularMovies(page: Int): MovieListResponse
}