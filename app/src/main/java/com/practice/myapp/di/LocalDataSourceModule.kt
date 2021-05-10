package com.practice.myapp.di

import com.practice.data.datasource.IMovieLocalDataSource
import com.practice.myapp.framework.db.MovieLocalDataSourceImpl
import com.practice.myapp.framework.db.dao.MovieDao
import com.practice.myapp.presentation.viewmodel.mapper.MovieDataListMapper
import com.practice.myapp.presentation.viewmodel.mapper.MovieEntityMapper
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
        movieEntityMapper: MovieEntityMapper,
        movieDataListMapper: MovieDataListMapper
    ): IMovieLocalDataSource {
        return MovieLocalDataSourceImpl(dao, movieEntityMapper, movieDataListMapper)
    }
}