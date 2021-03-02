package com.practice.presentation.di

import com.practice.domain.di.DomainModule
import dagger.Module

@Module(
    includes = [
        ViewModelModule::class
    ]
)
class PresentationModule {
}