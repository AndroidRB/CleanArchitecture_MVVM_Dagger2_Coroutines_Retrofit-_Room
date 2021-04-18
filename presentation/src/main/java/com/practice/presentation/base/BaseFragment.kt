package com.practice.presentation.base

import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
abstract class BaseFragment : Fragment() {

    @Inject lateinit var viewModelFactory: ViewModelFactory
}