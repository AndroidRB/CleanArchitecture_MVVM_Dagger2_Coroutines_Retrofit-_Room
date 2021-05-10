package com.practice.myapp.presentation.ui.movielist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.practice.myapp.databinding.AdapterPopularMoviesItemBinding
import com.practice.myapp.presentation.viewmodel.data.MovieView
import com.practice.myapp.presentation.ui.movielist.adapter.holder.PopularMoviesListViewHolder
import com.practice.myapp.presentation.ui.movielist.adapter.listener.OnItemClickListener

class PopularMoviesListAdapter(
    private val mDataSet: MutableList<MovieView>,
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

    fun setData(mDataSet: List<MovieView>?) {
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