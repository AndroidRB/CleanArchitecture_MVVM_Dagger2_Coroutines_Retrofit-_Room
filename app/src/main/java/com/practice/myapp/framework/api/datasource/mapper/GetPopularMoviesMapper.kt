package com.practice.myapp.framework.api.datasource.mapper

import com.practice.domain.model.Movie
import com.practice.myapp.framework.api.response.MovieListResponse
import com.practice.myapp.framework.api.response.MovieResponse
import com.practice.myapp.common.Mapper

class GetPopularMoviesMapper : Mapper<MovieListResponse, List<Movie>> {

    override fun map(i: MovieListResponse): List<Movie> {
        return i.movies!!.map(::mapData)
    }

    private fun mapData(movie: MovieResponse) =
        Movie(
            movieId = movie.id?.toLong() ?: 0L,
            movieTitle = movie.title ?: "",
            moviePosterUrl = movie.posterPath ?: ""
        )
}