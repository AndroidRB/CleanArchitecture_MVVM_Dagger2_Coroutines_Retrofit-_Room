package com.practice.domain.di

import dagger.Module

@Module(
    includes = [
        UseCaseModule::class
    ]
)
class DomainModule