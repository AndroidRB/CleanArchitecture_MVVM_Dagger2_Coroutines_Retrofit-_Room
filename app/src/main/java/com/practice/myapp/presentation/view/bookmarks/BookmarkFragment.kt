package com.practice.myapp.presentation.view.bookmarks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.practice.domain.model.Movie
import com.practice.myapp.presentation.view.base.BaseFragment
import com.practice.myapp.databinding.FragmentBookmarkBinding
import com.practice.myapp.presentation.view.bookmarks.adapter.BookmarkAdapter
import com.practice.myapp.presentation.view.bookmarks.adapter.listener.OnItemClickListener
import com.practice.myapp.presentation.viewmodel.BookmarkViewModel

class BookmarkFragment : BaseFragment(), OnItemClickListener {

    private var _binding: FragmentBookmarkBinding? = null
    private val binding get() = _binding

    private val viewModel: BookmarkViewModel by viewModels()
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

    private fun setMovies(movieItems: List<Movie>) {
        adapter.setData(movieItems)
        setEmptyState(adapter.itemCount == 0)
    }

    private fun setEmptyState(isEmpty: Boolean) {
        binding?.rvContainer?.visibility = if (isEmpty) View.GONE else View.VISIBLE
        binding?.tvEmptyState?.visibility = if (isEmpty) View.VISIBLE else View.GONE
    }


    override fun onItemClick(movie: Movie) {
        findNavController().navigate(
            BookmarkFragmentDirections.actionNavigationBookmarkToDetailsFragment(
                movie
            )
        )
    }

    override fun onRemoveIconClick(movie: Movie) {
        adapter.clearData()
        viewModel.removeMovieFromDb(movie.movieId)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}