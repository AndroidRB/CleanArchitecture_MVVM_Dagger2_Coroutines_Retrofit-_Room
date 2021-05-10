package com.practice.myapp.presentation.ui.bookmarks.adapter.listener

import com.practice.myapp.presentation.viewmodel.data.MovieView

interface OnItemClickListener {
    fun onItemClick(movieItem: MovieView)
    fun onRemoveIconClick(movieItem: MovieView)
}