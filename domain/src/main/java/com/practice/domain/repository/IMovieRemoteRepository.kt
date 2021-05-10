package com.practice.domain.repository

import com.practice.domain.model.MovieItem

interface IMovieRemoteRepository {
    suspend fun getPopularMovies(page: Int): List<MovieItem>?
}