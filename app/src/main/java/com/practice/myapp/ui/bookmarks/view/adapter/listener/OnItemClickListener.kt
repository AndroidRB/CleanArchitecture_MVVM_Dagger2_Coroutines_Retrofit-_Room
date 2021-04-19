package com.practice.myapp.ui.bookmarks.view.adapter.listener

import com.practice.domain.usecase.data.MovieItem

interface OnItemClickListener {
    fun onItemClick(movieItem: MovieItem)
    fun onRemoveIconClick(movieItem: MovieItem)
}