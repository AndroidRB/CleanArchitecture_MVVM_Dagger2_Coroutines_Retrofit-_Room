package com.practice.myapp.framework.api.response

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
class MovieResponse(
    @SerializedName("id")
    @Expose
    var id: Int? = null,
    @SerializedName("poster_path")
    @Expose
    var posterPath: String? = null,
    @SerializedName("title")
    @Expose
    var title: String? = null
): Parcelable