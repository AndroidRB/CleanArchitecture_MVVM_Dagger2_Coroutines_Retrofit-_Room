package com.practice.data.repository.mapper.local

import com.practice.data.db.entity.MovieEntity
import com.practice.domain.usecase.data.MovieItem
import com.practice.data.repository.mapper.common.Mapper

class AddMovieMapper : Mapper<MovieItem, MovieEntity> {

    override fun map(i: MovieItem) = MovieEntity(name = i.movieTitle, posterPath = i.moviePosterUrl)
}