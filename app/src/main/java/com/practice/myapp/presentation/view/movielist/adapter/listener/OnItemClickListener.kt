package com.practice.myapp.presentation.view.movielist.adapter.listener

import com.practice.domain.entity.Movie


interface OnItemClickListener {
    fun onItemClick(movieItem: Movie)
    fun onBookmarkIconClick(movieItem: Movie)
}