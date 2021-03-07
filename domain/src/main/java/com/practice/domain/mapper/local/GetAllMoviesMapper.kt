package com.practice.domain.mapper.local

import com.practice.data.db.entity.MovieEntity
import com.practice.domain.entity.Movie
import com.practice.domain.mapper.common.Mapper

class GetAllMoviesMapper: Mapper<List<MovieEntity>, List<Movie>> {

    override fun map(i: List<MovieEntity>) = i.map(::createMovieDataSet)

    private fun createMovieDataSet(movieEntity: MovieEntity) =
        Movie(
            movieId = movieEntity.id.toInt(),
            movieTitle = movieEntity.name,
            moviePosterUrl = movieEntity.posterPath
        )
}