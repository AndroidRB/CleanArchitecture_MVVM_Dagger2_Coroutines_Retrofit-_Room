package com.practice.data.repository.mapper.local

import com.practice.data.model.Movie
import com.practice.data.repository.mapper.common.Mapper
import com.practice.domain.usecase.data.MovieItem

class GetAllMoviesMapper: Mapper<List<Movie>, List<MovieItem>> {

    override fun map(i: List<Movie>) = i.map(::createDataSet)

    private fun createDataSet(movieEntity: Movie) =
        MovieItem(
            movieId = movieEntity.movieId,
            movieTitle = movieEntity.movieTitle,
            moviePosterUrl = movieEntity.moviePosterUrl
        )
}