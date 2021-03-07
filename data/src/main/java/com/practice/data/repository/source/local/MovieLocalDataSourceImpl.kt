package com.practice.data.repository.source.local

import android.content.Context
import com.practice.data.db.MovieDatabase
import com.practice.data.db.entity.MovieEntity
import javax.inject.Inject

class MovieLocalDataSourceImpl (
    context: Context
) : MovieLocalDataSource {

    private val dao = MovieDatabase.getInstance(context).getDao()

    override suspend fun insertMovie(movie: MovieEntity) = dao.insert(movie)

    override suspend fun getAllMovies() = dao.getAllMovies()

    override suspend fun deleteMovie(movieId: Long) = dao.deleteMovie(movieId)
}