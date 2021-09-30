package com.practice.myapp.framework.di

import com.practice.data.datasource.IMovieRemoteDataSource
import com.practice.myapp.framework.api.datasource.MovieRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteDataSourceModule {

    @Binds
    abstract fun bindsRemoteDataSource(dataSource: MovieRemoteDataSource): IMovieRemoteDataSource
}