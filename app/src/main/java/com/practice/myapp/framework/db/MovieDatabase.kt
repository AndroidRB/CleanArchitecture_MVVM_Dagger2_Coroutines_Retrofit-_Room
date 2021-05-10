package com.practice.myapp.framework.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.practice.myapp.framework.db.dao.MovieDao
import com.practice.myapp.framework.db.entity.MovieDBEntity

@Database(entities = [MovieDBEntity::class], version = 1)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun getDao(): MovieDao
}