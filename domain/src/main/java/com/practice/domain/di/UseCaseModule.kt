package com.practice.domain.di

import com.practice.data.repository.MovieRemoteRepository
import com.practice.domain.usecase.GetPopularMoviesUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun providesGetPopularMoviesUseCase(repository: MovieRemoteRepository) =
        GetPopularMoviesUseCase(repository)
}