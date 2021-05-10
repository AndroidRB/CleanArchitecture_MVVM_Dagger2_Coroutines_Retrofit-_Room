package com.practice.myapp.di

import com.practice.data.repository.MovieLocalRepository
import com.practice.data.repository.MovieRemoteRepository
import com.practice.data.repository.mapper.local.AddMovieMapper
import com.practice.data.repository.mapper.local.GetAllMoviesMapper
import com.practice.data.repository.mapper.remote.PopularMoviesListMapper
import com.practice.data.datasource.local.IMovieLocalDataSource
import com.practice.data.datasource.remote.IMovieRemoteDataSource
import com.practice.domain.repository.IMovieLocalRepository
import com.practice.domain.repository.IMovieRemoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun providesMovieRemoteRepository(
        remoteDataSource: IMovieRemoteDataSource,
        mapper: PopularMoviesListMapper
    ): IMovieRemoteRepository {
        return MovieRemoteRepository(remoteDataSource, mapper)
    }

    @Provides
    fun providesMovieLocalRepository(
        localDataSource: IMovieLocalDataSource,
        addMovieMapper: AddMovieMapper,
        getAllMoviesMapper: GetAllMoviesMapper
    ): IMovieLocalRepository {
        return MovieLocalRepository(localDataSource, addMovieMapper, getAllMoviesMapper)
    }
}