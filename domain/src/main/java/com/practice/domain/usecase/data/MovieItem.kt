package com.practice.domain.usecase.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieItem(
    val movieId: Int,
    val movieTitle: String,
    val moviePosterUrl: String
) : Parcelable
