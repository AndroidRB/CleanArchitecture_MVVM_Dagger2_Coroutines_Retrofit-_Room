package com.practice.data.datasource.local

import com.practice.data.db.dao.MovieDao
import com.practice.data.db.entity.MovieEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieLocalDataSourceImpl (
    private val dao: MovieDao
) : IMovieLocalDataSource {

    override suspend fun insertMovie(movie: MovieEntity) = withContext(Dispatchers.IO) {
        return@withContext dao.insert(movie)
    }

    override suspend fun getAllMovies() = withContext(Dispatchers.IO) {
        return@withContext  dao.getAllMovies()
    }

    override suspend fun deleteMovie(movieId: Long) = withContext(Dispatchers.IO) {
        return@withContext dao.deleteMovie(movieId)
    }
}