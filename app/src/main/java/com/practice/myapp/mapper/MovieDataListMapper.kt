package com.practice.myapp.mapper

import com.practice.data.model.Movie
import com.practice.data.repository.mapper.common.Mapper
import com.practice.myapp.framework.db.entity.MovieEntity

class MovieDataListMapper: Mapper<List<MovieEntity>, List<Movie>> {
    override fun map(i: List<MovieEntity>) = i.map(::createDataSet)


    private fun createDataSet(i: MovieEntity) =
        Movie(
            movieId = i.id.toInt(),
            movieTitle = i.name,
            moviePosterUrl = i.posterPath
        )
}