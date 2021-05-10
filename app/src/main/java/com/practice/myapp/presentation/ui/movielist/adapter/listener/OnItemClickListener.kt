package com.practice.myapp.presentation.ui.movielist.adapter.listener

import com.practice.myapp.presentation.viewmodel.data.MovieDetailsItem

interface OnItemClickListener {
    fun onItemClick(movieItem: MovieDetailsItem)
    fun onBookmarkIconClick(movieItem: MovieDetailsItem)
}