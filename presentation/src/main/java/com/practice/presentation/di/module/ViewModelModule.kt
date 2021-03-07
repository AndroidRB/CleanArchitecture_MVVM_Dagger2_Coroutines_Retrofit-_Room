package com.practice.presentation.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.practice.presentation.base.ViewModelFactory
import com.practice.presentation.base.ViewModelKey
import com.practice.presentation.ui.bookmarks.viewmodel.BookmarkViewModel
import com.practice.presentation.ui.movielist.viewmodel.MovieListViewModel
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

    @Binds
    @IntoMap
    @ViewModelKey(BookmarkViewModel::class)
    abstract fun bindBookmarkViewModel(viewModel: BookmarkViewModel): ViewModel
}