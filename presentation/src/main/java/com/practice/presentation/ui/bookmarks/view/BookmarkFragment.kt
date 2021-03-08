package com.practice.presentation.ui.bookmarks.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.practice.domain.entity.Movie
import com.practice.presentation.base.BaseFragment
import com.practice.presentation.databinding.FragmentBookmarkBinding
import com.practice.presentation.ui.bookmarks.view.adapter.BookmarkAdapter
import com.practice.presentation.ui.bookmarks.view.adapter.listener.OnItemClickListener
import com.practice.presentation.ui.bookmarks.viewmodel.BookmarkViewModel

class BookmarkFragment : BaseFragment(), OnItemClickListener {

    private lateinit var binding: FragmentBookmarkBinding
    private lateinit var viewModel: BookmarkViewModel
    private lateinit var adapter: BookmarkAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentBookmarkBinding.inflate(inflater, container, false).apply {
        binding = this
        initValues()
        initObservers()
        initListeners()
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        getMovies()
    }

    private fun initValues() {
        viewModel = ViewModelProvider(this, viewModelFactory).get(BookmarkViewModel::class.java)
        binding.rvContainer.layoutManager = LinearLayoutManager(requireContext())
        adapter = BookmarkAdapter(mutableListOf(), this)
        binding.rvContainer.adapter = adapter
    }

    private fun initObservers() {
        viewModel.isLoading.observe(viewLifecycleOwner, {
            binding.swipeRefreshLayout.isRefreshing = it
        })
        viewModel.moviesFromDb.observe(viewLifecycleOwner, {
            setMovies(it)
        })
    }

    private fun initListeners() {
        binding.swipeRefreshLayout.setOnRefreshListener {
            adapter.clearData()
            getMovies()
        }
    }

    private fun getMovies() {
        viewModel.getPopularMoviesFromDb()
    }

    private fun setMovies(movies: List<Movie>) {
        adapter.setData(movies)
        setEmptyState(adapter.itemCount == 0)
    }

    private fun setEmptyState(isEmpty: Boolean) {
        binding.rvContainer.visibility = if (isEmpty) View.GONE else View.VISIBLE
        binding.tvEmptyState.visibility = if (isEmpty) View.VISIBLE else View.GONE
    }


    override fun onItemClick(movie: Movie) {

    }

    override fun onRemoveIconClick(movie: Movie) {
        adapter.clearData()
        viewModel.removeMovieFromDb(movie.movieId.toLong())
    }
}