package com.practice.data.mapper

import com.practice.data.db.entity.MovieDBEntity
import com.practice.domain.entity.Movie

class InsertMovieMapper : Mapper<Movie, MovieDBEntity> {
    override fun map(i: Movie) =
        MovieDBEntity(
            id = i.movieId,
            name = i.movieTitle,
            posterPath = i.moviePosterUrl
        )
}