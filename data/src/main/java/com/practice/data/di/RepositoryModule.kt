package com.practice.data.di

import com.practice.data.repository.MovieLocalRepository
import com.practice.data.repository.MovieRemoteRepository
import com.practice.data.repository.source.local.MovieLocalDataSource
import com.practice.data.repository.source.remote.MovieRemoteDataSource
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun providesMovieRemoteRepository(remoteDataSource: MovieRemoteDataSource) =
        MovieRemoteRepository(remoteDataSource)

    @Provides
    fun providesMovieLocalRepository(localDataSource: MovieLocalDataSource) =
        MovieLocalRepository(localDataSource)
}