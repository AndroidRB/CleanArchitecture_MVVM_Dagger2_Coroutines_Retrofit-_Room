package com.practice.myapp.framework.db.datasource.mapper

import com.practice.domain.model.Movie
import com.practice.myapp.framework.db.entity.MovieDBEntity
import com.practice.myapp.common.Mapper

class GetAllMoviesMapper : Mapper<List<MovieDBEntity>, List<Movie>> {

    override fun map(i: List<MovieDBEntity>) = i.map(::createDataSet)

    private fun createDataSet(movieEntity: MovieDBEntity) =
        Movie(
            movieId = movieEntity.id,
            movieTitle = movieEntity.name,
            moviePosterUrl = movieEntity.posterPath
        )
}