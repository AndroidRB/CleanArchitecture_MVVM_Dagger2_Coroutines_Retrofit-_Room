package com.practice.myapp.ui.bookmarks.view.adapter.listener

import com.practice.myapp.mapper.model.MovieDetailsItem

interface OnItemClickListener {
    fun onItemClick(movieItem: MovieDetailsItem)
    fun onRemoveIconClick(movieItem: MovieDetailsItem)
}