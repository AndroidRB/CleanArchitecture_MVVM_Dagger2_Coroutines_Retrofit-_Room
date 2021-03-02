package com.practice.domain.mapper

import com.practice.domain.entity.Movie
import com.practice.domain.mapper.common.Mapper
import javax.inject.Inject

class PopularMoviesListMapper @Inject constructor() :
    Mapper<List<com.practice.data.api.model.Movie>, List<Movie>> {

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