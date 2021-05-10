package com.practice.myapp.presentation.viewmodel.mapper

import com.practice.data.repository.mapper.common.Mapper
import com.practice.domain.model.MovieItem
import com.practice.myapp.presentation.viewmodel.data.MovieDetailsItem

class MovieItemMapper: Mapper<MovieDetailsItem, MovieItem> {

    override fun map(i: MovieDetailsItem): MovieItem {
        return MovieItem(
            movieId = i.movieId,
            movieTitle = i.movieTitle,
            moviePosterUrl = i.moviePosterUrl
        )
    }
}