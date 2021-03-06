package com.practice.data.di

import com.practice.data.repository.source.MovieRemoteDataSource
import com.practice.data.repository.source.MovieRemoteDataSourceImpl
import dagger.Binds
import dagger.Module

@Module
abstract class RemoteDataSourceModule {

    @Binds
    abstract fun bindsRemoteDataSourceImpl(dataSourceImpl: MovieRemoteDataSourceImpl): MovieRemoteDataSource
}