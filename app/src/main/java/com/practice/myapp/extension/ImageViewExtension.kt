package com.practice.myapp.extension

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.practice.myapp.util.Constants

fun ImageView.loadImageUrl(imageUrl: String) {
    Glide.with(this.context)
        .load(Constants.IMAGE_BASE_URL + imageUrl)
        .into(this)
}