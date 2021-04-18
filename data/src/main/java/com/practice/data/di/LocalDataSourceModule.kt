package com.practice.data.di

import com.practice.data.db.dao.MovieDao
import com.practice.data.repository.source.local.IMovieLocalDataSource
import com.practice.data.repository.source.local.MovieLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataSourceModule {

    @Singleton
    @Provides
    fun provideLocalDataSource(dao: MovieDao): IMovieLocalDataSource {
        return MovieLocalDataSourceImpl(dao)
    }
}