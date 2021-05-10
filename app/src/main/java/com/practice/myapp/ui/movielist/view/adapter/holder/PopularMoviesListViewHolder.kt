package com.practice.myapp.ui.movielist.view.adapter.holder

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.practice.myapp.databinding.AdapterPopularMoviesItemBinding
import com.practice.myapp.mapper.model.MovieDetailsItem
import com.practice.myapp.ui.movielist.view.adapter.listener.OnItemClickListener
import com.practice.myapp.util.Constants

class PopularMoviesListViewHolder(private val itemBinding: AdapterPopularMoviesItemBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {

    private lateinit var item: MovieDetailsItem
    private lateinit var listener: OnItemClickListener

    init {
        itemBinding.itemParent.setOnClickListener {
            listener.onItemClick(item)
        }
        itemBinding.ivBookmark.setOnClickListener {
            listener.onBookmarkIconClick(item)
        }
    }

    fun bind(item: MovieDetailsItem, listener: OnItemClickListener) {
        this.item = item
        this.listener = listener

        itemBinding.tvTitle.text = item.movieTitle
        Glide.with(itemView.context)
            .load(Constants.IMAGE_BASE_URL + item.moviePosterUrl)
            .into(itemBinding.ivBg)
    }
}