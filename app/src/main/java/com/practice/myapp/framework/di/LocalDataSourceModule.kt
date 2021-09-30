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