package com.practice.myapp

import com.practice.myapp.di.ApplicationGraph
import com.practice.myapp.di.DaggerApplicationGraph
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class BaseApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val appComponent: ApplicationGraph = DaggerApplicationGraph.builder()
            .application(this).build()
        appComponent.inject(this)
        return appComponent
    }
}