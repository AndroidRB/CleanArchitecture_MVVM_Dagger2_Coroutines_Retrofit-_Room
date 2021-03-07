package com.practice.presentation.ui.bookmarks.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practice.domain.entity.Movie
import com.practice.domain.usecase.local.GetAllMoviesUseCase
import kotlinx.coroutines.launch

class BookmarkViewModel(
    private val getAllMoviesUseCase: GetAllMoviesUseCase
): ViewModel() {

    private var _moviesFromDb = MutableLiveData<List<Movie>>()
    val moviesFromDb = _moviesFromDb

    private var _isLoading = MutableLiveData<Boolean>()
    val isLoading = _isLoading

    fun getPopularMoviesFromDb() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val response = getAllMoviesUseCase()
            isLoading.postValue(false)
            _moviesFromDb.postValue(response)
        }
    }
}