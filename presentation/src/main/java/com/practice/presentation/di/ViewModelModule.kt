package com.practice.presentation.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.practice.presentation.base.ViewModelFactory
import com.practice.presentation.base.ViewModelKey
import com.practice.presentation.ui.bookmarks.viewmodel.BookmarkViewModel
import com.practice.presentation.ui.movielist.viewmodel.MovieListViewModel
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoMap

@Module
@InstallIn(SingletonComponent::class)
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MovieListViewModel::class)
    abstract fun bindHomeViewModel(viewModel: MovieListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(BookmarkViewModel::class)
    abstract fun bindBookmarkViewModel(viewModel: BookmarkViewModel): ViewModel
}