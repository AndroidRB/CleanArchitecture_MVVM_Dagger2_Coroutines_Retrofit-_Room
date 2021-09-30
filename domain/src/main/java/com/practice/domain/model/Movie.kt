package com.practice.domain.model

import java.io.Serializable

data class Movie(
    val movieId: Long,
    val movieTitle: String,
    val moviePosterUrl: String
): Serializable
