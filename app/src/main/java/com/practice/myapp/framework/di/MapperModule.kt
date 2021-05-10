package com.practice.myapp.framework.di

import com.practice.data.repository.mapper.local.AddMovieMapper
import com.practice.data.repository.mapper.local.GetAllMoviesMapper
import com.practice.data.repository.mapper.remote.PopularMoviesListMapper
import com.practice.myapp.presentation.viewmodel.mapper.*
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

    @Provides
    fun providesMovieItemMapper() = MovieItemMapper()

    @Provides
    fun providesMoviesDetailsListMapper() = MoviesDetailsListMapper()

    @Provides
    fun providesMoviesEntityMapper() = MovieEntityMapper()

    @Provides
    fun providesMoviesDataMapper() = MovieDataMapper()

    @Provides
    fun providesMoviesDataListMapper() = MovieDataListMapper()

    @Provides
    fun providesGetPopularMoviesMapper() = GetPopularMoviesMapper()
}