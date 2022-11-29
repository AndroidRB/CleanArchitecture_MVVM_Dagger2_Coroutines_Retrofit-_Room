package com.practice.data.mapper

import com.practice.domain.entity.Movie
import com.practice.data.db.entity.MovieDBEntity
class GetAllMoviesMapper : Mapper<List<MovieDBEntity>, List<Movie>> {

    override fun map(i: List<MovieDBEntity>) = i.map(::createDataSet)

    private fun createDataSet(movieEntity: MovieDBEntity) =
        Movie(
            movieId = movieEntity.id,
            movieTitle = movieEntity.name,
            moviePosterUrl = movieEntity.posterPath
        )
}