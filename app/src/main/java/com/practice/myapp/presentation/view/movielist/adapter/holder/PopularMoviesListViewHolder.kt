package com.practice.myapp.presentation.view.movielist.adapter.holder

import androidx.recyclerview.widget.RecyclerView
import com.practice.domain.entity.Movie
import com.practice.myapp.common.extensions.loadImageUrl
import com.practice.myapp.databinding.AdapterPopularMoviesItemBinding
import com.practice.myapp.presentation.view.movielist.adapter.listener.OnItemClickListener

class PopularMoviesListViewHolder(private val itemBinding: AdapterPopularMoviesItemBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {

    private lateinit var item: Movie
    private lateinit var listener: OnItemClickListener

    init {
        itemBinding.itemParent.setOnClickListener {
            listener.onItemClick(item)
        }
        itemBinding.ivBookmark.setOnClickListener {
            listener.onBookmarkIconClick(item)
        }
    }

    fun bind(item: Movie, listener: OnItemClickListener) {
        this.item = item
        this.listener = listener

        itemBinding.tvTitle.text = item.movieTitle
        itemBinding.ivBg.loadImageUrl(item.moviePosterUrl)
    }
}