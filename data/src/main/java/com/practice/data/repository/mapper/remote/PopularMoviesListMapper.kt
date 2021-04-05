package com.practice.data.repository.mapper.remote

import com.practice.data.api.model.Movie
import com.practice.data.api.model.MovieListResponse
import com.practice.domain.usecase.data.MovieItem
import com.practice.data.repository.mapper.common.Mapper

class PopularMoviesListMapper :
    Mapper<MovieListResponse, List<MovieItem>?> {

    override fun map(i: MovieListResponse): List<MovieItem>? {
        return i.movies?.map(::mapData)
    }

    private fun mapData(movie: Movie) =
        MovieItem(
            movieId = movie.id ?: -1,
            movieTitle = movie.title ?: "",
            moviePosterUrl = movie.posterPath ?: ""
        )
}