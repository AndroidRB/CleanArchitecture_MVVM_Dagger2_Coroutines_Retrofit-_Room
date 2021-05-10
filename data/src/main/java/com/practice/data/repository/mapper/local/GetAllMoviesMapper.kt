package com.practice.data.repository.mapper.local

import com.practice.data.model.MovieEntity
import com.practice.data.repository.mapper.common.Mapper
import com.practice.domain.model.MovieItem

class GetAllMoviesMapper: Mapper<List<MovieEntity>, List<MovieItem>> {

    override fun map(i: List<MovieEntity>) = i.map(::createDataSet)

    private fun createDataSet(movieEntity: MovieEntity) =
        MovieItem(
            movieId = movieEntity.movieId,
            movieTitle = movieEntity.movieTitle,
            moviePosterUrl = movieEntity.moviePosterUrl
        )
}