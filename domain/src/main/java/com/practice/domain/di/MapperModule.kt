package com.practice.domain.di

import com.practice.domain.mapper.local.AddMovieMapper
import com.practice.domain.mapper.remote.PopularMoviesListMapper
import dagger.Module
import dagger.Provides

@Module
class MapperModule {

    @Provides
    fun providesPopularMoviesListMapper() = PopularMoviesListMapper()

    @Provides
    fun providesAddMovieMapper() = AddMovieMapper()
}