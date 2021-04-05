package com.practice.data.repository.mapper.local

import com.practice.data.db.entity.MovieEntity
import com.practice.domain.usecase.data.MovieItem
import com.practice.data.repository.mapper.common.Mapper

class GetAllMoviesMapper: Mapper<List<MovieEntity>, List<MovieItem>> {

    override fun map(i: List<MovieEntity>) = i.map(::createMovieDataSet)

    private fun createMovieDataSet(movieEntity: MovieEntity) =
        MovieItem(
            movieId = movieEntity.id.toInt(),
            movieTitle = movieEntity.name,
            moviePosterUrl = movieEntity.posterPath
        )
}