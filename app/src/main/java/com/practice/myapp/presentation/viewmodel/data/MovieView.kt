package com.practice.myapp.presentation.viewmodel.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieView(
    val movieId: Int = -1,
    val movieTitle: String = "",
    val moviePosterUrl: String = ""
): Parcelable