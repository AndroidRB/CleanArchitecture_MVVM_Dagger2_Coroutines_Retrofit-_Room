package com.practice.myapp.presentation.view.bookmarks.adapter.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.practice.domain.entity.Movie
import com.practice.myapp.common.extensions.loadImageUrl
import com.practice.myapp.databinding.AdapterPopularMoviesItemBinding
import com.practice.myapp.presentation.view.bookmarks.adapter.listener.OnItemClickListener

class BookmarkViewHolder(
    private val itemBinding: AdapterPopularMoviesItemBinding
    ) : RecyclerView.ViewHolder(itemBinding.root) {

    private lateinit var item: Movie
    private lateinit var listener: OnItemClickListener

    init {
        itemBinding.itemParent.setOnClickListener {
            listener.onItemClick(item)
        }
        itemBinding.ivRemove.setOnClickListener {
            listener.onRemoveIconClick(item)
        }
    }

    fun bind(item: Movie, listener: OnItemClickListener) {
        this.item = item
        this.listener = listener

        itemBinding.ivBookmark.visibility = View.GONE
        itemBinding.ivRemove.visibility = View.VISIBLE

        itemBinding.tvTitle.text = item.movieTitle
        itemBinding.ivBg.loadImageUrl(item.moviePosterUrl)
    }
}