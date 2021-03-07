package com.practice.data.di

import dagger.Module

@Module(
    includes = [
        ApiModule::class,
        RepositoryModule::class,
        RemoteDataSourceModule::class,
        LocalDataSourceModule::class
//        RoomModule::class
    ]
)
class DataModule