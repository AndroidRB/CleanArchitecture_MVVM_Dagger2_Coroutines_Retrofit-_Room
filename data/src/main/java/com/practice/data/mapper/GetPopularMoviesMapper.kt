package com.practice.data.mapper

import com.practice.domain.entity.Movie
import com.practice.data.network.response.MovieListResponse
import com.practice.data.network.response.MovieResponse

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