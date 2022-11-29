package com.practice.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.practice.data.db.dao.MovieDao
import com.practice.data.db.entity.MovieDBEntity

@Database(entities = [MovieDBEntity::class], version = 1)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun getDao(): MovieDao
}