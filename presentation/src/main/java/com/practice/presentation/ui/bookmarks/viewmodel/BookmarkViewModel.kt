package com.practice.presentation.ui.bookmarks.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.practice.domain.entity.Movie

class BookmarkViewModel(

): ViewModel() {

    private var _moviesFromDb = MutableLiveData<List<Movie>>()
    val moviesFromDb = _moviesFromDb

    private var _isLoading = MutableLiveData<Boolean>()
    val isLoading = _isLoading


}