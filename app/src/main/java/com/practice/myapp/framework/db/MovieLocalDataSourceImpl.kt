package com.practice.myapp.framework.db

import com.practice.data.datasource.IMovieLocalDataSource
import com.practice.data.model.Movie
import com.practice.myapp.framework.db.dao.MovieDao
import com.practice.myapp.mapper.MovieDataListMapper
import com.practice.myapp.mapper.MovieEntityMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieLocalDataSourceImpl (
    private val dao: MovieDao,
    private val movieEntityMapper: MovieEntityMapper,
    private val movieDataListMapper: MovieDataListMapper
) : IMovieLocalDataSource {

    override suspend fun insertMovie(movie: Movie) = withContext(Dispatchers.IO) {
        return@withContext dao.insert(movieEntityMapper.map(movie))
    }

    override suspend fun getAllMovies() = withContext(Dispatchers.IO) {
        return@withContext movieDataListMapper.map(dao.getAllMovies())
    }

    override suspend fun deleteMovie(movieId: Long) = withContext(Dispatchers.IO) {
        return@withContext dao.deleteMovie(movieId)
    }
}