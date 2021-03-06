package com.practice.data.repository

import com.practice.data.repository.source.local.MovieLocalDataSource

class MovieLocalRepository(
    private val localDataSource: MovieLocalDataSource
) {

}