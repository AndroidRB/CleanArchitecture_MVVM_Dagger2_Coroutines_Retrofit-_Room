package com.practice.myapp.framework.api

import com.practice.data.datasource.IMovieRemoteDataSource
import com.practice.myapp.presentation.viewmodel.mapper.GetPopularMoviesMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

const val API_KEY = "fbae83def54b1c6503519cd26f55b807"

class MovieRemoteDataSourceImpl @Inject constructor(
    private val service: ApiService,
    private val getPopularMoviesMapper: GetPopularMoviesMapper
) : IMovieRemoteDataSource {

    override suspend fun getPopularMovies(page: Int) = withContext(Dispatchers.IO) {
        return@withContext getPopularMoviesMapper.map(service.getPopularMovies(API_KEY, page))
    }
}