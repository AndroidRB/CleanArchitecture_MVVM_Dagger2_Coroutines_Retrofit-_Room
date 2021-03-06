package com.practice.data.repository

import com.practice.data.repository.source.MovieRemoteDataSource

class MovieLocalRepository(
    private val remoteDataSource: MovieRemoteDataSource
) {

}