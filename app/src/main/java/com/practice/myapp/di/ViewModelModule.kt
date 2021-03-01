package com.practice.myapp.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.practice.myapp.base.ViewModelFactory
import com.practice.myapp.base.ViewModelKey
import com.practice.myapp.ui.movielist.viewmodel.MovieListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MovieListViewModel::class)
    abstract fun bindHomeViewModel(viewModel: MovieListViewModel): ViewModel
}