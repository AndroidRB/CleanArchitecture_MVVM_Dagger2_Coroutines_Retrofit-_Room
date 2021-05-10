package com.practice.myapp.di

import com.practice.domain.repository.IMovieLocalRepository
import com.practice.domain.repository.IMovieRemoteRepository
import com.practice.domain.usecase.local.AddMovieUseCase
import com.practice.domain.usecase.local.GetAllMoviesUseCase
import com.practice.domain.usecase.local.RemoveMovieUseCase
import com.practice.domain.usecase.remote.GetPopularMoviesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    fun providesGetPopularMoviesUseCase(
        repository: IMovieRemoteRepository
    ) = GetPopularMoviesUseCase(repository)

    @Provides
    fun providesAddMovieUseCase(
        repository: IMovieLocalRepository
    ) = AddMovieUseCase(repository)

    @Provides
    fun provideGetAllMoviesUseCase(
        repository: IMovieLocalRepository
    ) = GetAllMoviesUseCase(repository)

    @Provides
    fun provideRemoveMovieUseCase(
        repository: IMovieLocalRepository
    ) = RemoveMovieUseCase(repository)
}