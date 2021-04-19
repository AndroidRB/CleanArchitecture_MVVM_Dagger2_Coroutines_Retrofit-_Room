package com.practice.myapp.ui.movielist.view.adapter.listener

import com.practice.domain.usecase.data.MovieItem

interface OnItemClickListener {
    fun onItemClick(movieItem: MovieItem)
    fun onBookmarkIconClick(movieItem: MovieItem)
}