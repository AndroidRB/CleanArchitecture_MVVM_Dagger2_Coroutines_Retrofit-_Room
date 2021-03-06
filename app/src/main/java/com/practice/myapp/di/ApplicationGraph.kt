package com.practice.myapp.di

import com.practice.data.di.DataModule
import com.practice.domain.di.DomainModule
import com.practice.presentation.di.FragmentSubComponent
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        DataModule::class,
        DomainModule::class
    ]
)
interface ApplicationComponent {

    fun fragmentSubComponent(): FragmentSubComponent.Factory
}