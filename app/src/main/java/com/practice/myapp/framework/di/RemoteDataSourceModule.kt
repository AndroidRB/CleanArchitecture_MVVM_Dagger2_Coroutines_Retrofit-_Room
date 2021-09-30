package com.practice.myapp.framework.di

import com.practice.data.datasource.IMovieRemoteDataSource
import com.practice.myapp.framework.api.datasource.MovieRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 *Here in this module we can see the difference between @Binds and @Provides
 *If we want to bind interface we must put @Inject in constructor like we put in MovieRemoteDataSource class,
 * else we can provide class without constructor inject, like in MovieLocalDataSource class
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteDataSourceModule {

    @Binds
    abstract fun bindsRemoteDataSource(dataSource: MovieRemoteDataSource): IMovieRemoteDataSource
}