package com.practice.myapp.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practice.domain.usecase.local.AddMovieUseCase
import com.practice.domain.usecase.remote.GetPopularMoviesUseCase
import com.practice.myapp.mapper.MovieItemMapper
import com.practice.myapp.mapper.MoviesDetailsListMapper
import com.practice.myapp.mapper.model.MovieDetailsItem
import kotlinx.coroutines.launch
import javax.inject.Inject

class MovieListViewModel @Inject constructor(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase,
    private val addMovieUseCase: AddMovieUseCase,
    private val movieItemMapper: MovieItemMapper,
    private val moviesDetailsListMapper: MoviesDetailsListMapper
) : ViewModel() {

    private var _popularMovies = MutableLiveData<List<MovieDetailsItem>>()
    val popularMovies = _popularMovies

    private var _isLoading = MutableLiveData<Boolean>()
    val isLoading = _isLoading

    private var page = 1

    fun getPopularMovies() {
        viewModelScope.launch {
            _isLoading.postValue(true)
            val response = getPopularMoviesUseCase(page++)?.let { moviesDetailsListMapper.map(it) }
            _isLoading.postValue(false)
            _popularMovies.postValue(response)
        }
    }

    fun refresh() {
        page = 1
    }

    fun addMovieIntoDb(movieDetailsItem: MovieDetailsItem) {
        viewModelScope.launch {
            _isLoading.postValue(true)
            addMovieUseCase(movieItemMapper.map(movieDetailsItem))
            _isLoading.postValue(false)
        }
    }
}