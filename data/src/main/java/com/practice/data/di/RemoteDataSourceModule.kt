package com.practice.data.di

import com.practice.data.repository.source.remote.IMovieRemoteDataSource
import com.practice.data.repository.source.remote.MovieRemoteDataSourceImpl
import dagger.Binds
import dagger.Module

@Module
abstract class RemoteDataSourceModule {

    @Binds
    abstract fun bindsRemoteDataSourceImpl(dataSourceImpl: MovieRemoteDataSourceImpl): IMovieRemoteDataSource
}