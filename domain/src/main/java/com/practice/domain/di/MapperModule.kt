package com.practice.domain.di

import com.practice.domain.mapper.PopularMoviesListMapper
import dagger.Module
import dagger.Provides

@Module
class MapperModule {

    @Provides
    fun providesPopularMoviesListMapper() = PopularMoviesListMapper()
}