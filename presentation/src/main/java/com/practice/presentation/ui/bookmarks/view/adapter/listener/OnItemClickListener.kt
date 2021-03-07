package com.practice.presentation.ui.bookmarks.view.adapter.listener

import com.practice.domain.entity.Movie

interface OnItemClickListener {
    fun onItemClick(movie: Movie)
    fun onRemoveIconClick(movie: Movie)
}