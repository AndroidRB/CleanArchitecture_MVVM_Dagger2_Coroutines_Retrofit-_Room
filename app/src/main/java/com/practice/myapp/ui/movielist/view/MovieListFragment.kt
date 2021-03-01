package com.practice.myapp.ui.movielist.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.practice.myapp.base.BaseFragment
import com.practice.myapp.databinding.FragmentMovieListBinding

class MovieListFragment : BaseFragment() {

    private lateinit var binding: FragmentMovieListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentMovieListBinding.inflate(inflater, container, false).apply {
        binding = this
    }.root


}