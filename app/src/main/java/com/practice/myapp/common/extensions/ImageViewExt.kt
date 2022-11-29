package com.practice.myapp.common.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide

const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w200/"
fun ImageView.loadImageUrl(imageUrl: String) {
    Glide.with(this.context)
        .load(IMAGE_BASE_URL + imageUrl)
        .into(this)
}