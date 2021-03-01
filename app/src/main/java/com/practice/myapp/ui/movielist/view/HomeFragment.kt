package com.practice.myapp.ui.movielist.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.practice.myapp.base.BaseFragment
import com.practice.myapp.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentHomeBinding.inflate(inflater, container, false).apply {
        binding = this
    }.root


}