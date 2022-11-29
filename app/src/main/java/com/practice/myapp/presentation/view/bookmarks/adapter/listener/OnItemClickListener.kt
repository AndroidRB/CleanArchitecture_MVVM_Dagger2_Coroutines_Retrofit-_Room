package com.practice.myapp.presentation.view.bookmarks.adapter.listener

import com.practice.domain.entity.Movie

interface OnItemClickListener {
    fun onItemClick(movie: Movie)
    fun onRemoveIconClick(movie: Movie)
}