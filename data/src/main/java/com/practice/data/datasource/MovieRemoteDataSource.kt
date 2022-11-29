package com.practice.data.datasource

import com.practice.data.datasource.contract.IMovieRemoteDataSource
import com.practice.data.mapper.GetPopularMoviesMapper
import com.practice.data.network.service.ApiService

class MovieRemoteDataSource(
    private val service: ApiService,
    private val getPopularMoviesMapper: GetPopularMoviesMapper
) : IMovieRemoteDataSource {

    override suspend fun getPopularMovies(page: Int) = getPopularMoviesMapper.map(service.getPopularMovies("fbae83def54b1c6503519cd26f55b807", page))
}