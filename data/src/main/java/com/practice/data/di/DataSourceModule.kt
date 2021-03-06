package com.practice.data.di

import com.practice.data.repository.source.remote.MovieRemoteDataSource
import com.practice.data.repository.source.remote.MovieRemoteDataSourceImpl
import dagger.Binds
import dagger.Module

@Module
abstract class DataSourceModule {

    @Binds
    abstract fun bindsRemoteDataSourceImpl(dataSourceImpl: MovieRemoteDataSourceImpl): MovieRemoteDataSource
}