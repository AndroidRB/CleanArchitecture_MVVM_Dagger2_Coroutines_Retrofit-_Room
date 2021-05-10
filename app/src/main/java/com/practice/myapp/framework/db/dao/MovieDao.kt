package com.practice.myapp.framework.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.practice.myapp.framework.db.entity.MovieDBEntity

/**
 * Data access object contains operations over databases
 */
@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(movieDB: MovieDBEntity)

    @Query("SELECT * FROM popular_movies_table")
    suspend fun getAllMovies(): List<MovieDBEntity>

    @Query("DELETE FROM popular_movies_table WHERE movie_id = :movieId")
    suspend fun deleteMovie(movieId: Long)

    @Query("DELETE FROM popular_movies_table")
    suspend fun deleteAllMovies()
}