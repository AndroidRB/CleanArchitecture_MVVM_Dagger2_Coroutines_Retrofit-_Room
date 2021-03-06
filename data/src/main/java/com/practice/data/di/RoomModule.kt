package com.practice.data.di

import android.app.Application
import androidx.room.Room
import com.practice.data.db.MovieDatabase
import com.practice.data.db.dao.MovieDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule {

    @Provides
    @Singleton
    fun provideMovieDatabase(applicationContext: Application): MovieDatabase {
        return Room.databaseBuilder(
            applicationContext,
            MovieDatabase::class.java,
            "movies.db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideMovieDao(database: MovieDatabase): MovieDao {
        return database.getDao()
    }
}