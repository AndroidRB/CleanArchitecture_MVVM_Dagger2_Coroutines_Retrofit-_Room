package com.practice.myapp

import android.app.Application
import com.practice.myapp.di.ApplicationComponent
import com.practice.myapp.di.DaggerApplicationComponent
import com.practice.presentation.di.Injector
import com.practice.presentation.di.FragmentSubComponent

class BaseApplication : Application(), Injector {

    private lateinit var appComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerApplicationComponent.builder().build()
    }

    override fun createFragmentSubComponent(): FragmentSubComponent {
        return appComponent.fragmentSubComponent().create()
    }
}