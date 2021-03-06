package com.practice.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "popular_movies_table")
data class MovieEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "movie_id")
    var id: Long = 0,
    @ColumnInfo(name = "movie_name")
    var name: String,
    @ColumnInfo(name = "movie_poster_path")
    var posterPath: String
)

