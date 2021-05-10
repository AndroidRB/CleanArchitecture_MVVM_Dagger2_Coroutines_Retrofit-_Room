package com.practice.myapp.mapper

import com.practice.data.model.Movie
import com.practice.data.repository.mapper.common.Mapper
import com.practice.myapp.framework.db.entity.MovieEntity

class MovieEntityMapper: Mapper<Movie, MovieEntity> {
    override fun map(i: Movie) =  MovieEntity(
        id = i.movieId.toLong(),
        name = i.movieTitle,
        posterPath = i.moviePosterUrl
    )
}