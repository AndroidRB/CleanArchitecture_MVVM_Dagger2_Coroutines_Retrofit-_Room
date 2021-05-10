package com.practice.myapp.presentation.ui.movielist.adapter.listener

import com.practice.myapp.presentation.viewmodel.data.MovieView

interface OnItemClickListener {
    fun onItemClick(movieItem: MovieView)
    fun onBookmarkIconClick(movieItem: MovieView)
}