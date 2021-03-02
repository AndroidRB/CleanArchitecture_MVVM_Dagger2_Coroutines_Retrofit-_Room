package com.practice.domain.di

import com.practice.data.di.DataModule
import dagger.Module

@Module(
    includes = [
        MapperModule::class,
        UseCaseModule::class
    ]
)
class DomainModule