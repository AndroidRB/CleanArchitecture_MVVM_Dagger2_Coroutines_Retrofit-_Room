package com.practice.myapp.framework.di

import com.practice.myapp.framework.api.datasource.mapper.GetPopularMoviesMapper
import com.practice.myapp.framework.db.datasource.mapper.GetAllMoviesMapper
import com.practice.myapp.framework.db.datasource.mapper.InsertMovieMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class MapperModule {

    @Provides
    fun providesGetPopularMoviesMapper() = GetPopularMoviesMapper()

    @Provides
    fun providesGetAllMoviesMapper() = GetAllMoviesMapper()

    @Provides
    fun providesInsertMovieMapper() = InsertMovieMapper()
}