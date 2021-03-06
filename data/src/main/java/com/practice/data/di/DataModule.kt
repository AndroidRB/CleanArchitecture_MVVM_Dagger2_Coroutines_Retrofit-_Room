package com.practice.data.di

import dagger.Module

@Module(
    includes = [
        ApiModule::class,
        RepositoryModule::class,
        RemoteDataSourceModule::class
    ]
)
class DataModule