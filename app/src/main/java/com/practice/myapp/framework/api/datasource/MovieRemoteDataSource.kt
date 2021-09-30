package com.practice.myapp.framework.api.datasource

import com.practice.data.datasource.IMovieRemoteDataSource
import com.practice.myapp.framework.api.datasource.mapper.GetPopularMoviesMapper
import com.practice.myapp.framework.api.service.ApiService
import com.practice.myapp.common.Constants.API_KEY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieRemoteDataSource @Inject constructor(
    private val service: ApiService,
    private val getPopularMoviesMapper: GetPopularMoviesMapper
) : IMovieRemoteDataSource {

    override suspend fun getPopularMovies(page: Int) = withContext(Dispatchers.IO) {
        return@withContext getPopularMoviesMapper.map(service.getPopularMovies(API_KEY, page))
    }
}