package com.practice.myapp.presentation.viewmodel.mapper

import com.practice.data.repository.mapper.common.Mapper
import com.practice.domain.model.MovieItem
import com.practice.myapp.presentation.viewmodel.data.MovieView

class MoviesDetailsListMapper: Mapper<List<MovieItem>, List<MovieView>> {

    override fun map(i: List<MovieItem>): List<MovieView> = i.map(::createDataSet)

    private fun createDataSet(i: MovieItem) =
        MovieView(
            movieId = i.movieId,
            movieTitle = i.movieTitle,
            moviePosterUrl = i.moviePosterUrl
        )

}