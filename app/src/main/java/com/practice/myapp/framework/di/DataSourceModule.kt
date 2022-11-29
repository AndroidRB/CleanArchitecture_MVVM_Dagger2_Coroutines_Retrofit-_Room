package com.practice.myapp.framework.di

import com.practice.data.datasource.contract.IMovieLocalDataSource
import com.practice.data.datasource.MovieLocalDataSource
import com.practice.data.datasource.MovieRemoteDataSource
import com.practice.data.datasource.contract.IMovieRemoteDataSource
import com.practice.data.db.dao.MovieDao
import com.practice.data.mapper.GetAllMoviesMapper
import com.practice.data.mapper.GetPopularMoviesMapper
import com.practice.data.mapper.InsertMovieMapper
import com.practice.data.network.service.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 *Here in this module we can see the difference between @Binds and @Provides
 *If we want to bind interface we must put @Inject in constructor like we put in MovieRemoteDataSource class,
 * else we can provide class without constructor inject, like in MovieLocalDataSource class
 */
@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {

    @Singleton
    @Provides
    fun provideLocalDataSource(
        dao: MovieDao,
        insertMovieMapper: InsertMovieMapper,
        getAllMoviesMapper: GetAllMoviesMapper
    ): IMovieLocalDataSource {
        return MovieLocalDataSource(dao, insertMovieMapper, getAllMoviesMapper)
    }

    @Singleton
    @Provides
    fun provideRemoteDataSource(
        service: ApiService,
        getPopularMoviesMapper: GetPopularMoviesMapper
    ): IMovieRemoteDataSource {
        return MovieRemoteDataSource(service, getPopularMoviesMapper)
    }
}