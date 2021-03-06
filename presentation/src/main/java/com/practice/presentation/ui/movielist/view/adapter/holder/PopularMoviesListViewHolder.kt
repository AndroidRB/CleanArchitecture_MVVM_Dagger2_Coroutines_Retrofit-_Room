package com.practice.presentation.ui.movielist.view.adapter.holder

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.practice.domain.entity.Movie
import com.practice.presentation.databinding.AdapterPopularMoviesItemBinding
import com.practice.presentation.ui.movielist.view.adapter.listener.OnItemClickListener
import com.practice.presentation.util.Constants

class PopularMoviesListViewHolder(private val itemBinding: AdapterPopularMoviesItemBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {

    private var item: Movie? = null
    private var listener: OnItemClickListener? = null

    init {
        itemBinding.itemParent.setOnClickListener {
            item?.let { it1 -> listener?.onItemClick(it1) }
        }
    }

    fun bind(item: Movie, listener: OnItemClickListener) {
        this.item = item
        this.listener = listener

        itemBinding.tvTitle.text = item.movieTitle
        Glide.with(itemView.context)
            .load(Constants.IMAGE_BASE_URL + item.moviePosterUrl)
            .into(itemBinding.ivBg)
    }
}