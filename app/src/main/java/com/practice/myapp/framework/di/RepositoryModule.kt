package com.practice.myapp.framework.di

import com.practice.data.repository.MovieLocalRepository
import com.practice.data.repository.MovieRemoteRepository
import com.practice.data.datasource.contract.IMovieLocalDataSource
import com.practice.data.datasource.contract.IMovieRemoteDataSource
import com.practice.domain.repository.IMovieLocalRepository
import com.practice.domain.repository.IMovieRemoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun providesMovieRemoteRepository(
        remoteDataSource: IMovieRemoteDataSource
    ): IMovieRemoteRepository {
        return MovieRemoteRepository(remoteDataSource)
    }

    @Provides
    fun providesMovieLocalRepository(
        localDataSource: IMovieLocalDataSource
    ): IMovieLocalRepository {
        return MovieLocalRepository(localDataSource)
    }
}