package com.practice.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.practice.data.db.dao.MovieDao
import com.practice.data.db.entity.MovieEntity

/**
 * Problems with injecting using dagger, so we provide database as singleton using companion object
 */
@Database(entities = [MovieEntity::class], version = 1)
abstract class MovieDatabase : RoomDatabase() {

    companion object {
        private const val DATABASE_NAME = "movies.db"
        private var instance: MovieDatabase? = null

        private fun create(context: Context) =
            Room.databaseBuilder(context, MovieDatabase::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()

        fun getInstance(context: Context) = (instance ?: create(context)).also { instance = it }
    }

    abstract fun getDao(): MovieDao
}