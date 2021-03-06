package com.practice.data.repository

import com.practice.data.db.entity.MovieEntity
import com.practice.data.repository.source.local.MovieLocalDataSource
import javax.inject.Inject

class MovieLocalRepository (
    private val localDataSource: MovieLocalDataSource
) {
    suspend fun addMovie(movie: MovieEntity) = localDataSource.insertMovie(movie)
}