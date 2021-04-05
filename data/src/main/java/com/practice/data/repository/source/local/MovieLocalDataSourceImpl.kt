package com.practice.data.repository.source.local

import android.content.Context
import com.practice.data.db.MovieDatabase
import com.practice.data.db.entity.MovieEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieLocalDataSourceImpl (
    context: Context
) : IMovieLocalDataSource {

    private val dao = MovieDatabase.getInstance(context).getDao()

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