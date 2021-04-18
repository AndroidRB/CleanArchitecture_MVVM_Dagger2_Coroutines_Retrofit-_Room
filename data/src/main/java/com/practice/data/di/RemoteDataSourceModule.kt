package com.practice.data.di

import com.practice.data.datasource.remote.IMovieRemoteDataSource
import com.practice.data.datasource.remote.MovieRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteDataSourceModule {

    @Binds
    abstract fun bindsRemoteDataSourceImpl(dataSourceImpl: MovieRemoteDataSourceImpl): IMovieRemoteDataSource
}