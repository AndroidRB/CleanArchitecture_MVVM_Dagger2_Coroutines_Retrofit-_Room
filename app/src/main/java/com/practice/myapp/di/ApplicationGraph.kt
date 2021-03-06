package com.practice.myapp.di

import com.practice.data.di.DataModule
import com.practice.domain.di.DomainModule
import com.practice.presentation.di.FragmentSubComponent
import com.practice.presentation.di.PresentationModule
import com.practice.presentation.di.ViewModelModule
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        PresentationModule::class,
        DataModule::class,
        DomainModule::class
    ]
)
interface ApplicationComponent {
    fun fragmentSubComponent(): FragmentSubComponent.Factory
}