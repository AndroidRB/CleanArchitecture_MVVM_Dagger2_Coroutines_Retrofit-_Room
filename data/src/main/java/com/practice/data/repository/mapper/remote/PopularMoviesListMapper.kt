package com.practice.data.repository.mapper.remote

import com.practice.data.model.MovieEntity
import com.practice.data.repository.mapper.common.Mapper
import com.practice.domain.model.MovieItem

class PopularMoviesListMapper :
    Mapper<List<MovieEntity>, List<MovieItem>?> {

    override fun map(i: List<MovieEntity>): List<MovieItem> {
        return i.map(::mapData)
    }

    private fun mapData(movieEntity: MovieEntity) =
        MovieItem(
            movieId = movieEntity.movieId,
            movieTitle = movieEntity.movieTitle,
            moviePosterUrl = movieEntity.moviePosterUrl
        )
}