package com.practice.myapp.presentation.view.bookmarks.adapter.listener

import com.practice.domain.model.Movie

interface OnItemClickListener {
    fun onItemClick(movie: Movie)
    fun onRemoveIconClick(movie: Movie)
}