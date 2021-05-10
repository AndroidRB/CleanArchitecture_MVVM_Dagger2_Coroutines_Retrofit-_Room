package com.practice.myapp.framework.di

import android.app.Application
import androidx.room.Room
import com.practice.myapp.framework.db.MovieDatabase
import com.practice.myapp.framework.db.dao.MovieDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RoomModule {

    @Provides
    fun provideMovieDatabase(application: Application): MovieDatabase {
        return Room.databaseBuilder(
            application,
            MovieDatabase::class.java,
            "movies.db"
        ).build()
    }

    @Provides
    fun provideMovieDao(database: MovieDatabase): MovieDao {
        return database.getDao()
    }
}