package com.practice.presentation.ui.movielist.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.practice.presentation.base.BaseFragment
import com.practice.presentation.base.ViewModelFactory
import com.practice.presentation.databinding.FragmentMovieListBinding
import javax.inject.Inject

class MovieListFragment : BaseFragment() {

    @Inject override lateinit var viewModeFactory: ViewModelFactory

    private lateinit var binding: FragmentMovieListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentMovieListBinding.inflate(inflater, container, false).apply {
        binding = this
    }.root


}