package com.practice.data.repository.mapper.local

import com.practice.data.model.MovieEntity
import com.practice.data.repository.mapper.common.Mapper
import com.practice.domain.model.MovieItem

class AddMovieMapper : Mapper<MovieItem, MovieEntity> {

    override fun map(i: MovieItem) = MovieEntity(
        movieId = i.movieId,
        movieTitle = i.movieTitle,
        moviePosterUrl = i.moviePosterUrl
    )
}