package com.practice.myapp.di

import com.practice.data.di.DataModule
import com.practice.domain.di.DomainModule
import com.practice.presentation.di.component.FragmentSubComponent
import com.practice.presentation.di.module.PresentationModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        PresentationModule::class,
        DomainModule::class,
        DataModule::class
    ]
)
interface ApplicationComponent {
    fun fragmentSubComponent(): FragmentSubComponent.Factory
}