package com.practice.domain.di

import dagger.Module

@Module(
    includes = [
        MapperModule::class,
        UseCaseModule::class
    ]
)
class DomainModule