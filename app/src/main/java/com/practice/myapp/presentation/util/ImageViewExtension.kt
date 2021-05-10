package com.practice.myapp.presentation.util

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImageUrl(imageUrl: String) {
    Glide.with(this.context)
        .load(Constants.IMAGE_BASE_URL + imageUrl)
        .into(this)
}