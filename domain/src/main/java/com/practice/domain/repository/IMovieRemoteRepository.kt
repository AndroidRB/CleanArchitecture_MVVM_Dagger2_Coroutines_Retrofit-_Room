package com.practice.domain.repository

import com.practice.domain.entity.Movie

interface IMovieRemoteRepository {
    suspend fun getPopularMovies(page: Int): List<Movie>?
}