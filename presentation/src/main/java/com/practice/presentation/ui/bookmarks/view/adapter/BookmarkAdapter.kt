package com.practice.presentation.ui.bookmarks.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.practice.domain.entity.Movie
import com.practice.presentation.databinding.AdapterPopularMoviesItemBinding
import com.practice.presentation.ui.bookmarks.view.adapter.holder.BookmarkViewHolder
import com.practice.presentation.ui.bookmarks.view.adapter.listener.OnItemClickListener

class BookmarkAdapter(
private val mDataSet: MutableList<Movie>,
private val listener: OnItemClickListener
) : RecyclerView.Adapter<BookmarkViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookmarkViewHolder {
        return BookmarkViewHolder(
            AdapterPopularMoviesItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: BookmarkViewHolder, position: Int) {
        holder.bind(mDataSet[position], listener)
    }

    override fun getItemCount() = mDataSet.size

    fun setData(mDataSet: List<Movie>?) {
        if (mDataSet != null) {
            this.mDataSet.addAll(mDataSet)
        }
        notifyDataSetChanged()
    }
}