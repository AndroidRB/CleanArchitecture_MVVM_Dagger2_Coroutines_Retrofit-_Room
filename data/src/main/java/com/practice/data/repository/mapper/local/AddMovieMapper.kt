package com.practice.data.repository.mapper.local

import com.practice.data.model.Movie
import com.practice.data.repository.mapper.common.Mapper
import com.practice.domain.model.MovieItem

class AddMovieMapper : Mapper<MovieItem, Movie> {

    override fun map(i: MovieItem) = Movie(
        movieId = i.movieId,
        movieTitle = i.movieTitle,
        moviePosterUrl = i.moviePosterUrl
    )
}