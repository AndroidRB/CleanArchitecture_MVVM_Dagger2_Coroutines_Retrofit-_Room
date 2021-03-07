package com.practice.data.di

import android.content.Context
import com.practice.data.repository.source.local.MovieLocalDataSource
import com.practice.data.repository.source.local.MovieLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataSourceModule {

    @Singleton
    @Provides
    fun provideLocalDataSource(context: Context): MovieLocalDataSource {
        return MovieLocalDataSourceImpl(context)
    }
}