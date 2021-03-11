package com.practice.presentation.extension

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.practice.presentation.util.Constants

fun ImageView.loadImageUrl(imageUrl: String) {
    Glide.with(this.context)
        .load(Constants.IMAGE_BASE_URL + imageUrl)
        .into(this)
}