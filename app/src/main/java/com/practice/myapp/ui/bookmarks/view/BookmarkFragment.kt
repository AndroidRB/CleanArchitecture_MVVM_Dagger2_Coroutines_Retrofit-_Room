package com.practice.myapp.ui.bookmarks.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.practice.domain.usecase.data.MovieItem
import com.practice.myapp.base.BaseFragment
import com.practice.myapp.databinding.FragmentBookmarkBinding
import com.practice.myapp.ui.bookmarks.view.adapter.BookmarkAdapter
import com.practice.myapp.ui.bookmarks.view.adapter.listener.OnItemClickListener
import com.practice.myapp.ui.bookmarks.viewmodel.BookmarkViewModel

class BookmarkFragment : BaseFragment(), OnItemClickListener {

    private var _binding: FragmentBookmarkBinding? = null
    private val binding get() = _binding

    private lateinit var viewModel: BookmarkViewModel
    private lateinit var adapter: BookmarkAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentBookmarkBinding.inflate(inflater, container, false).apply {
        _binding = this
        initValues()
        initObservers()
        initListeners()
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        getMovies()
    }

    private fun initValues() {
        viewModel = ViewModelProvider(this, viewModelFactory).get(BookmarkViewModel::class.java)
        binding?.rvContainer?.layoutManager = LinearLayoutManager(requireContext())
        adapter = BookmarkAdapter(mutableListOf(), this)
        binding?.rvContainer?.adapter = adapter
    }

    private fun initObservers() {
        viewModel.isLoading.observe(viewLifecycleOwner, {
            binding?.swipeRefreshLayout?.isRefreshing = it
        })
        viewModel.moviesFromDb.observe(viewLifecycleOwner, {
            adapter.clearData()
            setMovies(it)
        })
    }

    private fun initListeners() {
        binding?.swipeRefreshLayout?.setOnRefreshListener {
            adapter.clearData()
            getMovies()
        }
    }

    private fun getMovies() {
        viewModel.getPopularMoviesFromDb()
    }

    private fun setMovies(movieItems: List<MovieItem>) {
        adapter.setData(movieItems)
        setEmptyState(adapter.itemCount == 0)
    }

    private fun setEmptyState(isEmpty: Boolean) {
        binding?.rvContainer?.visibility = if (isEmpty) View.GONE else View.VISIBLE
        binding?.tvEmptyState?.visibility = if (isEmpty) View.VISIBLE else View.GONE
    }


    override fun onItemClick(movieItem: MovieItem) {
        findNavController().navigate(
            BookmarkFragmentDirections.actionNavigationBookmarkToDetailsFragment(
                movieItem
            )
        )
    }

    override fun onRemoveIconClick(movieItem: MovieItem) {
        adapter.clearData()
        viewModel.removeMovieFromDb(movieItem.movieId.toLong())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}