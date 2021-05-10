package com.practice.myapp.ui.movielist.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.practice.myapp.databinding.AdapterPopularMoviesItemBinding
import com.practice.myapp.mapper.model.MovieDetailsItem
import com.practice.myapp.ui.movielist.view.adapter.holder.PopularMoviesListViewHolder
import com.practice.myapp.ui.movielist.view.adapter.listener.OnItemClickListener

class PopularMoviesListAdapter(
    private val mDataSet: MutableList<MovieDetailsItem>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<PopularMoviesListViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PopularMoviesListViewHolder {
        return PopularMoviesListViewHolder(
            AdapterPopularMoviesItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(
        holder: PopularMoviesListViewHolder,
        position: Int
    ) {
        holder.bind(mDataSet[position], listener)
    }

    override fun getItemCount(): Int {
        return mDataSet.size
    }

    fun setData(mDataSet: List<MovieDetailsItem>?) {
        if (mDataSet != null) {
            this.mDataSet.addAll(mDataSet)
        }
        notifyDataSetChanged()
    }

    fun clearData() {
        mDataSet.clear()
        notifyDataSetChanged()
    }
}