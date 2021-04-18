package com.practice.data.di

import com.practice.data.repository.mapper.local.AddMovieMapper
import com.practice.data.repository.mapper.local.GetAllMoviesMapper
import com.practice.data.repository.mapper.remote.PopularMoviesListMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class MapperModule {

    @Provides
    fun providesPopularMoviesListMapper() = PopularMoviesListMapper()

    @Provides
    fun providesAddMovieMapper() = AddMovieMapper()

    @Provides
    fun provideGetAllMoviesMapper() = GetAllMoviesMapper()
}