package com.practice.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    val movieId: Int,
    val movieTitle: String,
    val moviePosterUrl: String
): Parcelable
