package com.practice.myapp.di

import android.app.Application
import android.content.Context
import com.practice.presentation.di.component.FragmentSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [FragmentSubComponent::class])
class AppModule(private val application: Application) {


    @Singleton
    @Provides
    fun provideApplication(): Application {
        return application
    }
}