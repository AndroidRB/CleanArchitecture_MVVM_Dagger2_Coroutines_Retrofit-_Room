package com.practice.domain.mapper.local

import com.practice.data.db.entity.MovieEntity
import com.practice.domain.entity.Movie
import com.practice.domain.mapper.common.Mapper

class AddMovieMapper : Mapper<Movie, MovieEntity> {

    override fun map(i: Movie) = MovieEntity(name = i.movieTitle, posterPath = i.moviePosterUrl)
}