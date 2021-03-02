package com.practice.data.repository.source

import com.practice.data.api.model.Movie

interface MovieDataSource {
    suspend fun getPopularMovies(page: Int): List<Movie>
}