package com.practice.data.di

import com.practice.data.datasource.remote.IMovieRemoteDataSource
import com.practice.data.datasource.remote.MovieRemoteDataSourceImpl
import dagger.Binds
import dagger.Module

@Module
abstract class RemoteDataSourceModule {

    @Binds
    abstract fun bindsRemoteDataSourceImpl(dataSourceImpl: MovieRemoteDataSourceImpl): IMovieRemoteDataSource
}