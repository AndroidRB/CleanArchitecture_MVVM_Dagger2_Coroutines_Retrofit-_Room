package com.practice.myapp.framework.db

import com.practice.data.datasource.IMovieLocalDataSource
import com.practice.data.model.MovieEntity
import com.practice.myapp.framework.db.dao.MovieDao
import com.practice.myapp.presentation.viewmodel.mapper.MovieDataListMapper
import com.practice.myapp.presentation.viewmodel.mapper.MovieEntityMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieLocalDataSourceImpl (
    private val dao: MovieDao,
    private val movieEntityMapper: MovieEntityMapper,
    private val movieDataListMapper: MovieDataListMapper
) : IMovieLocalDataSource {

    override suspend fun insertMovie(movieEntity: MovieEntity) = withContext(Dispatchers.IO) {
        return@withContext dao.insert(movieEntityMapper.map(movieEntity))
    }

    override suspend fun getAllMovies() = withContext(Dispatchers.IO) {
        return@withContext movieDataListMapper.map(dao.getAllMovies())
    }

    override suspend fun deleteMovie(movieId: Long) = withContext(Dispatchers.IO) {
        return@withContext dao.deleteMovie(movieId)
    }
}