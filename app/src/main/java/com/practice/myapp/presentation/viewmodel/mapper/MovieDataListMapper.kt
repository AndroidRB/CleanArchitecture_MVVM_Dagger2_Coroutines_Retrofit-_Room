package com.practice.myapp.presentation.viewmodel.mapper

import com.practice.data.model.MovieEntity
import com.practice.data.repository.mapper.common.Mapper
import com.practice.myapp.framework.db.entity.MovieDBEntity

class MovieDataListMapper: Mapper<List<MovieDBEntity>, List<MovieEntity>> {
    override fun map(i: List<MovieDBEntity>) = i.map(::createDataSet)


    private fun createDataSet(i: MovieDBEntity) =
        MovieEntity(
            movieId = i.id.toInt(),
            movieTitle = i.name,
            moviePosterUrl = i.posterPath
        )
}