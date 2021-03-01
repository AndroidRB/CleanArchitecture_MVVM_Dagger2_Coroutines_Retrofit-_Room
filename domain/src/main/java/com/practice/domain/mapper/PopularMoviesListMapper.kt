package com.practice.domain.mapper

import android.content.Context
import com.practice.domain.entity.Movie
import com.practice.domain.mapper.common.Mapper

class PopularMoviesListMapper(
    private val context: Context
) : Mapper<List<com.practice.data.api.model.Movie>, List<Movie>> {

    override fun map(i: List<com.practice.data.api.model.Movie>): List<Movie> {
        return i.map(::mapData)
    }

    private fun mapData(movie: com.practice.data.api.model.Movie) =
        Movie(
            movieId = movie.id ?: -1,
            movieTitle = movie.title ?: "",
            moviePosterUrl = movie.posterPath ?: ""
        )
}