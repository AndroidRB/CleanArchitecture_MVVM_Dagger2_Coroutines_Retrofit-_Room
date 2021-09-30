package com.practice.myapp.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practice.domain.model.Movie
import com.practice.domain.usecase.local.AddMovieUseCase
import com.practice.domain.usecase.remote.GetPopularMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase,
    private val addMovieUseCase: AddMovieUseCase
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

    fun refresh() {
        page = 1
    }

    fun addMovieIntoDb(movie: Movie) {
        viewModelScope.launch {
            _isLoading.postValue(true)
            addMovieUseCase(movie)
            _isLoading.postValue(false)
        }
    }
}