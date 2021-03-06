package com.practice.presentation.di.injector

import com.practice.presentation.di.component.FragmentSubComponent

interface Injector {
    fun createFragmentSubComponent(): FragmentSubComponent
}