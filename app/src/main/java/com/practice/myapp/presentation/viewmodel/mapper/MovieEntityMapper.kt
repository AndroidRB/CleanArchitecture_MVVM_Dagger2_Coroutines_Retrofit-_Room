package com.practice.myapp.presentation.viewmodel.mapper

import com.practice.data.model.MovieEntity
import com.practice.data.repository.mapper.common.Mapper
import com.practice.myapp.framework.db.entity.MovieDBEntity

class MovieEntityMapper: Mapper<MovieEntity, MovieDBEntity> {
    override fun map(i: MovieEntity) =  MovieDBEntity(
        id = i.movieId.toLong(),
        name = i.movieTitle,
        posterPath = i.moviePosterUrl
    )
}