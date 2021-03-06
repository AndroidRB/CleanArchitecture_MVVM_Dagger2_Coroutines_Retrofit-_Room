package com.practice.data.repository.source

import com.practice.data.api.model.MovieListResponse

interface MovieRemoteDataSource {
    suspend fun getPopularMovies(page: Int): MovieListResponse
}