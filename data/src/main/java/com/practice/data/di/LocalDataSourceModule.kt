package com.practice.data.di

import com.practice.data.db.dao.MovieDao
import com.practice.data.datasource.local.IMovieLocalDataSource
import com.practice.data.datasource.local.MovieLocalDataSourceImpl
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
    fun provideLocalDataSource(dao: MovieDao): IMovieLocalDataSource {
        return MovieLocalDataSourceImpl(dao)
    }
}