package com.practice.presentation.ui.bookmarks.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.practice.presentation.base.BaseFragment
import com.practice.presentation.databinding.FragmentBookmarkBinding
import com.practice.presentation.ui.bookmarks.view.adapter.BookmarkAdapter
import com.practice.presentation.ui.bookmarks.viewmodel.BookmarkViewModel

class BookmarkFragment : BaseFragment() {

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
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }

    private fun initValues() {

    }

    private fun initObservers() {

    }
}