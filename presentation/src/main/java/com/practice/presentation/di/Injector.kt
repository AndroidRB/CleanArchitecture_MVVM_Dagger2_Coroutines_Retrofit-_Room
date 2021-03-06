package com.practice.presentation.di

import com.practice.presentation.di.FragmentSubComponent

interface Injector {
    fun createFragmentSubComponent(): FragmentSubComponent
}