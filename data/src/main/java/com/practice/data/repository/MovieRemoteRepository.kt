package com.practice.data.repository

import com.practice.data.repository.mapper.remote.PopularMoviesListMapper
import com.practice.data.datasource.IMovieRemoteDataSource
import com.practice.domain.repository.IMovieRemoteRepository

class MovieRemoteRepository(
    private val remoteDataSource: IMovieRemoteDataSource,
    private val popularMoviesListMapper: PopularMoviesListMapper
) : IMovieRemoteRepository {

    override suspend fun getPopularMovies(page: Int) =
        popularMoviesListMapper.map(remoteDataSource.getPopularMovies(page))
}