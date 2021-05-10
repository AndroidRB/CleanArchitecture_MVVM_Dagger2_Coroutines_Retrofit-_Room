package com.practice.myapp.mapper.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieDetailsItem(
    val movieId: Int = -1,
    val movieTitle: String = "",
    val moviePosterUrl: String = ""
): Parcelable