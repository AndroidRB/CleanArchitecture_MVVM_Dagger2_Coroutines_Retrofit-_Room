package com.practice.myapp.framework.di

import com.practice.data.datasource.IMovieLocalDataSource
import com.practice.myapp.framework.db.datasource.MovieLocalDataSource
import com.practice.myapp.framework.db.dao.MovieDao
import com.practice.myapp.framework.db.datasource.mapper.GetAllMoviesMapper
import com.practice.myapp.framework.db.datasource.mapper.InsertMovieMapper
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
class LocalDataSourceModule {

    @Singleton
    @Provides
    fun provideLocalDataSource(
        dao: MovieDao,
        insertMovieMapper: InsertMovieMapper,
        getAllMoviesMapper: GetAllMoviesMapper
    ): IMovieLocalDataSource {
        return MovieLocalDataSource(dao, insertMovieMapper, getAllMoviesMapper)
    }
}