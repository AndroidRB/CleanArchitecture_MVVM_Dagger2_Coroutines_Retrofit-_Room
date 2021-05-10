package com.practice.myapp.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practice.domain.usecase.local.GetAllMoviesUseCase
import com.practice.domain.usecase.local.RemoveMovieUseCase
import com.practice.myapp.presentation.viewmodel.mapper.MoviesDetailsListMapper
import com.practice.myapp.presentation.viewmodel.data.MovieView
import kotlinx.coroutines.launch
import javax.inject.Inject

class BookmarkViewModel @Inject constructor(
    private val getAllMoviesUseCase: GetAllMoviesUseCase,
    private val removeMovieUseCase: RemoveMovieUseCase,
    private val moviesDetailsListMapper: MoviesDetailsListMapper
): ViewModel() {

    private var _moviesFromDb = MutableLiveData<List<MovieView>>()
    val moviesFromDb = _moviesFromDb

    private var _isLoading = MutableLiveData<Boolean>()
    val isLoading = _isLoading

    fun getPopularMoviesFromDb() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val response = moviesDetailsListMapper.map(getAllMoviesUseCase())
            isLoading.postValue(false)
            _moviesFromDb.postValue(response)
        }
    }

    fun removeMovieFromDb(movieId: Long) {
        viewModelScope.launch {
            isLoading.postValue(true)
            removeMovieUseCase(movieId)
            val response = moviesDetailsListMapper.map(getAllMoviesUseCase())
            isLoading.postValue(false)
            _moviesFromDb.postValue(response)
        }
    }
}