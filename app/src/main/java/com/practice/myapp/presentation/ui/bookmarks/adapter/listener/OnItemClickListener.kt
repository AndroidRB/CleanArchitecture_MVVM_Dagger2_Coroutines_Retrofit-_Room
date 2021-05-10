package com.practice.myapp.presentation.ui.bookmarks.adapter.listener

import com.practice.myapp.mapper.model.MovieDetailsItem

interface OnItemClickListener {
    fun onItemClick(movieItem: MovieDetailsItem)
    fun onRemoveIconClick(movieItem: MovieDetailsItem)
}