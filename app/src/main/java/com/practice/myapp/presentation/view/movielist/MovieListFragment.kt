package com.practice.myapp.presentation.view.movielist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.practice.domain.entity.Movie
import com.practice.myapp.databinding.FragmentMovieListBinding
import com.practice.myapp.presentation.view.base.BaseFragment
import com.practice.myapp.presentation.view.movielist.adapter.PopularMoviesListAdapter
import com.practice.myapp.presentation.view.movielist.adapter.listener.OnItemClickListener
import com.practice.myapp.presentation.viewmodel.MovieListViewModel

class MovieListFragment : BaseFragment(), NestedScrollView.OnScrollChangeListener,
    SwipeRefreshLayout.OnRefreshListener, OnItemClickListener {

    private var _binding: FragmentMovieListBinding? = null
    private val binding get() = _binding

    private val viewModel: MovieListViewModel by viewModels()
    private lateinit var gridLayoutManager: GridLayoutManager
    private lateinit var adapter: PopularMoviesListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentMovieListBinding.inflate(inflater, container, false).apply {
        _binding = this
        initValues()
        initObservers()
        initListeners()
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getPopularMovies()
    }

    private fun initValues() {
        adapter = PopularMoviesListAdapter(mutableListOf(), this)
        gridLayoutManager = GridLayoutManager(requireContext(), 2)
        binding?.rvContainer?.layoutManager = gridLayoutManager
        binding?.rvContainer?.adapter = adapter
    }

    private fun initObservers() {
        viewModel.isLoading.observe(viewLifecycleOwner, {
            binding?.swipeRefreshLayout?.isRefreshing = it
        })
        viewModel.popularMovies.observe(viewLifecycleOwner, {
            setPopularMovies(it)
        })
    }

    private fun getPopularMovies() {
        viewModel.getPopularMovies()
    }

    private fun setPopularMovies(movieItems: List<Movie>) {
        adapter.setData(movieItems)
        setEmptyState(adapter.itemCount == 0)
    }

    private fun initListeners() {
        binding?.nestedParent?.setOnScrollChangeListener(this)
        binding?.swipeRefreshLayout?.setOnRefreshListener(this)
    }

    private fun setEmptyState(isEmpty: Boolean) {
        binding?.rvContainer?.visibility = if (isEmpty) View.GONE else View.VISIBLE
        binding?.tvEmptyState?.visibility = if (isEmpty) View.VISIBLE else View.GONE
    }

    private fun clearMovieList() {
        adapter.clearData()
    }

    override fun onScrollChange(
        v: NestedScrollView,
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

    override fun onItemClick(movieItem: Movie) {
        findNavController().navigate(
            MovieListFragmentDirections.actionNavigationHomeToDetailsFragment(
                movieItem
            )
        )
    }

    override fun onBookmarkIconClick(movieItem: Movie) {
        viewModel.addMovieIntoDb(movieItem)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}