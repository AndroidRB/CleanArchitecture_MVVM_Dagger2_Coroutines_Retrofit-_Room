package com.practice.myapp

import com.practice.myapp.di.ApplicationComponent
import com.practice.myapp.di.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class BaseApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val appComponent: ApplicationComponent = DaggerApplicationComponent.builder()
            .application(this).build()
        appComponent.inject(this)
        return appComponent
    }
}