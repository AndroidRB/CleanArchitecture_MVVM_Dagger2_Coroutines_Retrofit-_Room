package com.practice.data.api

import com.practice.data.api.model.Movie
import com.practice.data.api.model.MovieListResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("movie/popular")
    fun getPopularMovies(
        @Query("api_key") apiKey: String?,
        @Query("page") page: Int
    ): MovieListResponse

    @GET("movie/{movie_id}")
    fun getMovieDetails(
        @Path("movie_id") movieId: Int,
        @Query("append_to_response") credits: String?
    ): Movie

}