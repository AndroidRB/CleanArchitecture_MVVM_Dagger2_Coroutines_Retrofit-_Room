package com.practice.presentation.ui.bookmarks.view.adapter.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.practice.domain.usecase.data.MovieItem
import com.practice.presentation.databinding.AdapterPopularMoviesItemBinding
import com.practice.presentation.ui.bookmarks.view.adapter.listener.OnItemClickListener
import com.practice.presentation.util.Constants

class BookmarkViewHolder(
    private val itemBinding: AdapterPopularMoviesItemBinding
    ) : RecyclerView.ViewHolder(itemBinding.root) {

    private lateinit var item: MovieItem
    private lateinit var listener: OnItemClickListener

    init {
        itemBinding.itemParent.setOnClickListener {
            listener.onItemClick(item)
        }
        itemBinding.ivRemove.setOnClickListener {
            listener.onRemoveIconClick(item)
        }
    }

    fun bind(item: MovieItem, listener: OnItemClickListener) {
        this.item = item
        this.listener = listener

        itemBinding.ivBookmark.visibility = View.GONE
        itemBinding.ivRemove.visibility = View.VISIBLE

        itemBinding.tvTitle.text = item.movieTitle
        Glide.with(itemView.context)
            .load(Constants.IMAGE_BASE_URL + item.moviePosterUrl)
            .into(itemBinding.ivBg)
    }
}