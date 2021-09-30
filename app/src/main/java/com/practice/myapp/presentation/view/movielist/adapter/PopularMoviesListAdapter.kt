package com.practice.myapp.presentation.view.movielist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.practice.domain.model.Movie
import com.practice.myapp.databinding.AdapterPopularMoviesItemBinding
import com.practice.myapp.presentation.view.movielist.adapter.holder.PopularMoviesListViewHolder
import com.practice.myapp.presentation.view.movielist.adapter.listener.OnItemClickListener

class PopularMoviesListAdapter(
    private val mDataSet: MutableList<Movie>,
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

    fun setData(mDataSet: List<Movie>?) {
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