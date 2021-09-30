package com.practice.domain.repository

import com.practice.domain.model.Movie

interface IMovieRemoteRepository {
    suspend fun getPopularMovies(page: Int): List<Movie>?
}