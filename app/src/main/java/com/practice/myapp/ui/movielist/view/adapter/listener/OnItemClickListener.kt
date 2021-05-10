package com.practice.myapp.ui.movielist.view.adapter.listener

import com.practice.myapp.mapper.model.MovieDetailsItem

interface OnItemClickListener {
    fun onItemClick(movieItem: MovieDetailsItem)
    fun onBookmarkIconClick(movieItem: MovieDetailsItem)
}