package com.practice.presentation.ui.movielist.view.adapter.listener

import com.practice.domain.entity.Movie

interface OnItemClickListener {
    fun onItemClick(movie: Movie)
}