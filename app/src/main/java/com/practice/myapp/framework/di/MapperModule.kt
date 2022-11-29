package com.practice.myapp.framework.di

import com.practice.data.mapper.GetPopularMoviesMapper
import com.practice.data.mapper.GetAllMoviesMapper
import com.practice.data.mapper.InsertMovieMapper
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