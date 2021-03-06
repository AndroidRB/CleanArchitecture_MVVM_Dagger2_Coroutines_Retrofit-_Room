package com.practice.data.di

import dagger.Module

@Module(
    includes = [
        ApiModule::class,
        RoomModule::class,
        RepositoryModule::class,
        DataSourceModule::class
    ]
)
class DataModule