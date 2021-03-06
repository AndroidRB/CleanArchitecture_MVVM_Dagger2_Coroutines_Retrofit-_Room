package com.practice.data.di

import com.practice.data.repository.MovieRemoteRepository
import com.practice.data.repository.source.remote.MovieRemoteDataSource
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun providesMovieRemoteRepository(remoteDataSource: MovieRemoteDataSource) =
        MovieRemoteRepository(remoteDataSource)
}