package com.practice.myapp.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practice.domain.model.Movie
import com.practice.domain.usecase.local.GetAllMoviesUseCase
import com.practice.domain.usecase.local.RemoveMovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookmarkViewModel @Inject constructor(
    private val getAllMoviesUseCase: GetAllMoviesUseCase,
    private val removeMovieUseCase: RemoveMovieUseCase,
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

    fun removeMovieFromDb(movieId: Long) {
        viewModelScope.launch {
            isLoading.postValue(true)
            removeMovieUseCase(movieId)
            val response = getAllMoviesUseCase()
            isLoading.postValue(false)
            _moviesFromDb.postValue(response)
        }
    }
}