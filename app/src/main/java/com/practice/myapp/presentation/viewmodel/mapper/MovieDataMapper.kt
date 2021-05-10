package com.practice.myapp.presentation.viewmodel.mapper

import com.practice.data.model.Movie
import com.practice.data.repository.mapper.common.Mapper
import com.practice.myapp.framework.db.entity.MovieEntity

class MovieDataMapper: Mapper<MovieEntity, Movie> {
    override fun map(i: MovieEntity) = Movie(
        movieId = i.id.toInt(),
        movieTitle = i.name,
        moviePosterUrl = i.posterPath
    )
}