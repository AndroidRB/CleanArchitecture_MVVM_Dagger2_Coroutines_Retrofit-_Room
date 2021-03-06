package com.practice.data.repository.source.local

import com.practice.data.db.dao.MovieDao
import com.practice.data.db.entity.MovieEntity
import javax.inject.Inject

class MovieLocalDataSourceImpl @Inject constructor(
    private val dao: MovieDao
) : MovieLocalDataSource {

    override suspend fun insertMovie(movie: MovieEntity) = dao.insert(movie)

    override suspend fun getAllMovies() = dao.getAllMovies()

    override suspend fun deleteMovie(movieId: Long) = dao.deleteMovie(movieId)
}