package com.practice.presentation.ui.movielist.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.NestedScrollView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.practice.domain.entity.Movie
import com.practice.presentation.base.BaseFragment
import com.practice.presentation.databinding.FragmentMovieListBinding
import com.practice.presentation.ui.movielist.view.adapter.PopularMoviesListAdapter
import com.practice.presentation.ui.movielist.view.adapter.listener.OnItemClickListener
import com.practice.presentation.ui.movielist.viewmodel.MovieListViewModel

class MovieListFragment : BaseFragment(), NestedScrollView.OnScrollChangeListener,
    SwipeRefreshLayout.OnRefreshListener, OnItemClickListener {

    private lateinit var binding: FragmentMovieListBinding
    private lateinit var viewModel: MovieListViewModel
    private lateinit var gridLayoutManager: GridLayoutManager
    private lateinit var adapter: PopularMoviesListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentMovieListBinding.inflate(inflater, container, false).apply {
        binding = this
        initValues()
        initObservers()
        initListeners()
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getPopularMovies()
    }

    private fun initValues() {
        viewModel = ViewModelProvider(this, viewModelFactory).get(MovieListViewModel::class.java)
        adapter = PopularMoviesListAdapter(mutableListOf(), this)
        gridLayoutManager = GridLayoutManager(requireContext(), 2)
        binding.rvContainer.layoutManager = gridLayoutManager
        binding.rvContainer.adapter = adapter
    }

    private fun initObservers() {
        viewModel.isLoading.observe(viewLifecycleOwner, {
            binding.swipeRefreshLayout.isRefreshing = it
        })
        viewModel.popularMovies.observe(viewLifecycleOwner, {
            setPopularMovies(it)
        })
    }

    private fun getPopularMovies() {
        viewModel.getPopularMovies()
    }

    private fun setPopularMovies(movies: List<Movie>) {
        adapter.setData(movies)
        setEmptyState(adapter.itemCount == 0)
    }

    private fun initListeners() {
        binding.nestedParent.setOnScrollChangeListener(this)
        binding.swipeRefreshLayout.setOnRefreshListener(this)
    }

    private fun setEmptyState(isEmpty: Boolean) {
        binding.rvContainer.visibility = if (isEmpty) View.GONE else View.VISIBLE
        binding.tvEmptyState.visibility = if (isEmpty) View.VISIBLE else View.GONE
    }

    private fun clearMovieList() {
        adapter.clearData()
    }

    override fun onScrollChange(
        v: NestedScrollView?,
        scrollX: Int,
        scrollY: Int,
        oldScrollX: Int,
        oldScrollY: Int
    ) {
        if (v?.getChildAt(v.childCount - 1) != null) {
            if ((scrollY >= (v.getChildAt(v.childCount - 1).measuredHeight - v.measuredHeight)) &&
                scrollY > oldScrollY
            ) {
                val visibleItemCount = gridLayoutManager.childCount
                val totalItemCount = gridLayoutManager.itemCount
                val pastVisibleItems = gridLayoutManager.findFirstVisibleItemPosition()

                if ((visibleItemCount + pastVisibleItems) >= totalItemCount) {
                    getPopularMovies()
                }
            }
        }
    }

    override fun onRefresh() {
        clearMovieList()
        viewModel.refresh()
        getPopularMovies()
    }

    override fun onItemClick(movie: Movie) {
        Toast.makeText(requireContext(), movie.movieTitle, Toast.LENGTH_SHORT).show()
    }

    override fun onBookmarkIconClick(movie: Movie) {

    }
}