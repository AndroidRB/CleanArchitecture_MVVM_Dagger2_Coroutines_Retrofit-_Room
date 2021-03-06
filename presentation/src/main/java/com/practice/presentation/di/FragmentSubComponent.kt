package com.practice.presentation.di

import com.practice.presentation.base.BaseFragment
import dagger.Subcomponent

@Subcomponent
interface FragmentSubComponent {

    fun inject(fragment: BaseFragment)

    @Subcomponent.Factory
    interface Factory{
        fun create():FragmentSubComponent
    }
}