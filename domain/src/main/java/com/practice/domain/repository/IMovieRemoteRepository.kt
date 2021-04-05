package com.practice.domain.repository

import com.practice.domain.usecase.data.MovieItem

interface IMovieRemoteRepository {
    suspend fun getPopularMovies(page: Int): List<MovieItem>?
}