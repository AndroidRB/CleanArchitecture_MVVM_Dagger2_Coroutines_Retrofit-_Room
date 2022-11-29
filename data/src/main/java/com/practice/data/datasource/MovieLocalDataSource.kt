package com.practice.data.datasource

import com.practice.data.datasource.contract.IMovieLocalDataSource
import com.practice.domain.entity.Movie
import com.practice.data.db.dao.MovieDao
import com.practice.data.mapper.GetAllMoviesMapper
import com.practice.data.mapper.InsertMovieMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieLocalDataSource(
    private val dao: MovieDao,
    private val insertMovieMapper: InsertMovieMapper,
    private val getAllMoviesMapper: GetAllMoviesMapper
) : IMovieLocalDataSource {

    override suspend fun insertMovie(movie: Movie) = dao.insert(insertMovieMapper.map(movie))

    override suspend fun getAllMovies() = getAllMoviesMapper.map(dao.getAllMovies())

    override suspend fun deleteMovie(movieId: Long) = dao.deleteMovie(movieId)
}