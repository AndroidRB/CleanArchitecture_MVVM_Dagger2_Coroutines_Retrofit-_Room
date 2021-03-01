package com.practice.data.source

interface MovieDataSource {
    suspend fun getPopularMovies(page: Int)
}