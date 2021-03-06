package com.practice.presentation.ui.movielist.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practice.domain.entity.Movie
import com.practice.domain.usecase.GetPopularMoviesUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class MovieListViewModel @Inject constructor(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase
) : ViewModel() {

    private var _popularMovies = MutableLiveData<List<Movie>>()
    val popularMovies = _popularMovies

    private var _isLoading = MutableLiveData<Boolean>()
    val isLoading = _isLoading

    private var page = 1

    fun getPopularMovies() {
        viewModelScope.launch {
            _isLoading.postValue(true)
            val response = getPopularMoviesUseCase(page++)
            _isLoading.postValue(false)
            _popularMovies.postValue(response)
        }
    }
}