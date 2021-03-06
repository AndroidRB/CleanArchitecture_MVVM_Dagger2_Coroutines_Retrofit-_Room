package com.practice.data.repository.source.remote

import com.practice.data.api.ApiService
import javax.inject.Inject

const val API_KEY = "fbae83def54b1c6503519cd26f55b807"

class MovieRemoteDataSourceImpl @Inject constructor(
    private val service: ApiService
) : MovieRemoteDataSource {

    override suspend fun getPopularMovies(page: Int) = service.getPopularMovies(API_KEY, page)
}