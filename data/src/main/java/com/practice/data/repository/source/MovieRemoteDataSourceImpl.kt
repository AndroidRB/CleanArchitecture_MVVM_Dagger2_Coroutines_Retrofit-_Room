package com.practice.data.repository.source

import com.practice.data.api.ApiService

const val API_KEY = "fbae83def54b1c6503519cd26f55b807"

class MovieRemoteDataSourceImpl(
    private val service: ApiService
) : MovieRemoteDataSource {

    override suspend fun getPopularMovies(page: Int) = service.getPopularMovies(API_KEY, page)
}