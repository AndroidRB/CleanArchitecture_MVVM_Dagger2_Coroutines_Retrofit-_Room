package com.practice.domain.di

import com.practice.data.repository.MovieLocalRepository
import com.practice.data.repository.MovieRemoteRepository
import com.practice.domain.mapper.local.AddMovieMapper
import com.practice.domain.mapper.remote.PopularMoviesListMapper
import com.practice.domain.usecase.local.AddMovieUseCase
import com.practice.domain.usecase.remote.GetPopularMoviesUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun providesGetPopularMoviesUseCase(
        repository: MovieRemoteRepository,
        mapper: PopularMoviesListMapper
    ) = GetPopularMoviesUseCase(repository, mapper)

    @Provides
    fun providesAddMovieUseCase(
        repository: MovieLocalRepository,
        mapper: AddMovieMapper
    ) = AddMovieUseCase(repository, mapper)
}