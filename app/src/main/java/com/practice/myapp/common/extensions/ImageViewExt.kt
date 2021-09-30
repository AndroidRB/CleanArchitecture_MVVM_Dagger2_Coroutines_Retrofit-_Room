package com.practice.myapp.common.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.practice.myapp.common.Constants

fun ImageView.loadImageUrl(imageUrl: String) {
    Glide.with(this.context)
        .load(Constants.IMAGE_BASE_URL + imageUrl)
        .into(this)
}