package com.practice.myapp.presentation.viewmodel.mapper

import com.practice.data.repository.mapper.common.Mapper
import com.practice.domain.model.MovieItem
import com.practice.myapp.presentation.viewmodel.data.MovieDetailsItem

class MoviesDetailsListMapper: Mapper<List<MovieItem>, List<MovieDetailsItem>> {

    override fun map(i: List<MovieItem>): List<MovieDetailsItem> = i.map(::createDataSet)

    private fun createDataSet(i: MovieItem) =
        MovieDetailsItem(
            movieId = i.movieId,
            movieTitle = i.movieTitle,
            moviePosterUrl = i.moviePosterUrl
        )

}