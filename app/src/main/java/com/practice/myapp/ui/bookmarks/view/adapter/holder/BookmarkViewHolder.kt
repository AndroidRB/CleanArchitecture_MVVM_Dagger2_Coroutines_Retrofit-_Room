package com.practice.myapp.ui.bookmarks.view.adapter.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.practice.domain.usecase.data.MovieItem
import com.practice.myapp.databinding.AdapterPopularMoviesItemBinding
import com.practice.myapp.mapper.model.MovieDetailsItem
import com.practice.myapp.ui.bookmarks.view.adapter.listener.OnItemClickListener
import com.practice.myapp.util.Constants

class BookmarkViewHolder(
    private val itemBinding: AdapterPopularMoviesItemBinding
    ) : RecyclerView.ViewHolder(itemBinding.root) {

    private lateinit var item: MovieDetailsItem
    private lateinit var listener: OnItemClickListener

    init {
        itemBinding.itemParent.setOnClickListener {
            listener.onItemClick(item)
        }
        itemBinding.ivRemove.setOnClickListener {
            listener.onRemoveIconClick(item)
        }
    }

    fun bind(item: MovieDetailsItem, listener: OnItemClickListener) {
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