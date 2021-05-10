package com.practice.myapp.mapper

import com.practice.data.repository.mapper.common.Mapper
import com.practice.domain.usecase.data.MovieItem
import com.practice.myapp.mapper.model.MovieDetailsItem

class MovieItemMapper: Mapper<MovieDetailsItem, MovieItem> {

    override fun map(i: MovieDetailsItem): MovieItem {
        return MovieItem(
            movieId = i.movieId,
            movieTitle = i.movieTitle,
            moviePosterUrl = i.moviePosterUrl
        )
    }
}