package com.practice.presentation.ui.movielist.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.practice.presentation.base.BaseFragment
import com.practice.presentation.base.ViewModelFactory
import com.practice.presentation.databinding.FragmentMovieListBinding
import com.practice.presentation.ui.movielist.viewmodel.MovieListViewModel
import javax.inject.Inject

class MovieListFragment : BaseFragment() {

    private lateinit var viewModel: MovieListViewModel

    private lateinit var binding: FragmentMovieListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentMovieListBinding.inflate(inflater, container, false).apply {
        binding = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initValues()
    }

    private fun initValues() {
//        viewModel = ViewModelProvider(this, viewModeFactory).get(MovieListViewModel::class.java)

//        adapter = PopularMoviesListAdapter(arrayListOf(), this)
//        gridLayoutManager = GridLayoutManager(requireContext(), 2)
//        viewLayout.rvContainer.layoutManager = gridLayoutManager
//        viewLayout.rvContainer.adapter = adapter
    }
}