package com.practice.data.di

import android.content.Context
import com.practice.data.repository.source.local.IMovieLocalDataSource
import com.practice.data.repository.source.local.MovieLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataSourceModule {

    @Singleton
    @Provides
    fun provideLocalDataSource(context: Context): IMovieLocalDataSource {
        return MovieLocalDataSourceImpl(context)
    }
}