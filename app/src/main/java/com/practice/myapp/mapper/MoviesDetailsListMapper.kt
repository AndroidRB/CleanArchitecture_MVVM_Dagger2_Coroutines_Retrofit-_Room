package com.practice.myapp.mapper

import com.practice.data.repository.mapper.common.Mapper
import com.practice.domain.usecase.data.MovieItem
import com.practice.myapp.mapper.model.MovieDetailsItem

class MoviesDetailsListMapper: Mapper<List<MovieItem>, List<MovieDetailsItem>> {

    override fun map(i: List<MovieItem>): List<MovieDetailsItem> = i.map(::createDataSet)

    private fun createDataSet(i: MovieItem) =
        MovieDetailsItem(
            movieId = i.movieId,
            movieTitle = i.movieTitle,
            moviePosterUrl = i.moviePosterUrl
        )

}