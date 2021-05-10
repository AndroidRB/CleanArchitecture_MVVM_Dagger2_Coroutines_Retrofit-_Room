package com.practice.myapp.presentation.viewmodel.mapper

import com.practice.data.model.MovieEntity
import com.practice.data.repository.mapper.common.Mapper
import com.practice.myapp.framework.api.model.MovieListResponse

class GetPopularMoviesMapper : Mapper<MovieListResponse, List<MovieEntity>> {

    override fun map(i: MovieListResponse): List<MovieEntity> {
        return i.movies!!.map(::mapData)
    }

    private fun mapData(movie: com.practice.myapp.framework.api.model.Movie) =
        MovieEntity(
            movieId = movie.id ?: -1,
            movieTitle = movie.title ?:"",
            moviePosterUrl = movie.posterPath ?:""
        )
}