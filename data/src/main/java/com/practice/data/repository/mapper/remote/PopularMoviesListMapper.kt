package com.practice.data.repository.mapper.remote

import com.practice.data.model.Movie
import com.practice.data.repository.mapper.common.Mapper
import com.practice.domain.model.MovieItem

class PopularMoviesListMapper :
    Mapper<List<Movie>, List<MovieItem>?> {

    override fun map(i: List<Movie>): List<MovieItem> {
        return i.map(::mapData)
    }

    private fun mapData(movie: Movie) =
        MovieItem(
            movieId = movie.movieId,
            movieTitle = movie.movieTitle,
            moviePosterUrl = movie.moviePosterUrl
        )
}