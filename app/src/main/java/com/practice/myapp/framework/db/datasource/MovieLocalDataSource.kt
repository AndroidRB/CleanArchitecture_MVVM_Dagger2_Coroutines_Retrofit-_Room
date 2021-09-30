package com.practice.myapp.framework.db.datasource

import com.practice.data.datasource.IMovieLocalDataSource
import com.practice.domain.model.Movie
import com.practice.myapp.framework.db.dao.MovieDao
import com.practice.myapp.framework.db.datasource.mapper.GetAllMoviesMapper
import com.practice.myapp.framework.db.datasource.mapper.InsertMovieMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieLocalDataSource(
    private val dao: MovieDao,
    private val insertMovieMapper: InsertMovieMapper,
    private val getAllMoviesMapper: GetAllMoviesMapper
) : IMovieLocalDataSource {

    override suspend fun insertMovie(movie: Movie) = withContext(Dispatchers.IO) {
        return@withContext dao.insert(insertMovieMapper.map(movie))
    }

    override suspend fun getAllMovies() = withContext(Dispatchers.IO) {
        return@withContext getAllMoviesMapper.map(dao.getAllMovies())
    }

    override suspend fun deleteMovie(movieId: Long) = withContext(Dispatchers.IO) {
        return@withContext dao.deleteMovie(movieId)
    }
}