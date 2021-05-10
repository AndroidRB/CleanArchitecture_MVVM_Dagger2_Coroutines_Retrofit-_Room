package com.practice.myapp.presentation.ui.movielist.adapter.holder

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.practice.myapp.databinding.AdapterPopularMoviesItemBinding
import com.practice.myapp.presentation.viewmodel.data.MovieView
import com.practice.myapp.presentation.ui.movielist.adapter.listener.OnItemClickListener
import com.practice.myapp.presentation.util.Constants

class PopularMoviesListViewHolder(private val itemBinding: AdapterPopularMoviesItemBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {

    private lateinit var item: MovieView
    private lateinit var listener: OnItemClickListener

    init {
        itemBinding.itemParent.setOnClickListener {
            listener.onItemClick(item)
        }
        itemBinding.ivBookmark.setOnClickListener {
            listener.onBookmarkIconClick(item)
        }
    }

    fun bind(item: MovieView, listener: OnItemClickListener) {
        this.item = item
        this.listener = listener

        itemBinding.tvTitle.text = item.movieTitle
        Glide.with(itemView.context)
            .load(Constants.IMAGE_BASE_URL + item.moviePosterUrl)
            .into(itemBinding.ivBg)
    }
}