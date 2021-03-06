package com.practice.domain.mapper

import com.practice.data.api.model.MovieListResponse
import com.practice.domain.entity.Movie
import com.practice.domain.mapper.common.Mapper

class PopularMoviesListMapper :
    Mapper<MovieListResponse, List<Movie>?> {

    override fun map(i: MovieListResponse): List<Movie>? {
        return i.movies?.map(::mapData)
    }

    private fun mapData(movie: com.practice.data.api.model.Movie) =
        Movie(
            movieId = movie.id ?: -1,
            movieTitle = movie.title ?: "",
            moviePosterUrl = movie.posterPath ?: ""
        )
}