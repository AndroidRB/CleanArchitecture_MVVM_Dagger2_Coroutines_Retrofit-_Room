package com.practice.myapp.presentation.viewmodel.mapper

import com.practice.data.repository.mapper.common.Mapper
import com.practice.domain.model.MovieItem
import com.practice.myapp.presentation.viewmodel.data.MovieView

class MovieItemMapper: Mapper<MovieView, MovieItem> {

    override fun map(i: MovieView): MovieItem {
        return MovieItem(
            movieId = i.movieId,
            movieTitle = i.movieTitle,
            moviePosterUrl = i.moviePosterUrl
        )
    }
}