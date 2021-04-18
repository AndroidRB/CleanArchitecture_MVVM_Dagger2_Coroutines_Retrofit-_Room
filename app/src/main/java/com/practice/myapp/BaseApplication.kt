package com.practice.myapp

import android.app.Application
import com.practice.myapp.di.AppModule
import com.practice.myapp.di.ApplicationComponent
import com.practice.myapp.di.DaggerApplicationComponent
import com.practice.presentation.di.component.FragmentSubComponent
import com.practice.presentation.di.injector.Injector

class BaseApplication : Application(), Injector {

    private lateinit var appComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerApplicationComponent.builder()
            .appModule(AppModule(this))
            .build()
    }

    override fun createFragmentSubComponent(): FragmentSubComponent {
        return appComponent.fragmentSubComponent().create()
    }
}