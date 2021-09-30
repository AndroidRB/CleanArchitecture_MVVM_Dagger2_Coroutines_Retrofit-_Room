package com.practice.myapp.framework.db.datasource.mapper

import com.practice.domain.model.Movie
import com.practice.myapp.framework.db.entity.MovieDBEntity
import com.practice.myapp.common.Mapper

class InsertMovieMapper : Mapper<Movie, MovieDBEntity> {
    override fun map(i: Movie) =
        MovieDBEntity(
            id = i.movieId,
            name = i.movieTitle,
            posterPath = i.moviePosterUrl
        )
}