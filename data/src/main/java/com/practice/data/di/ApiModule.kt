package com.practice.data.di

import com.google.gson.GsonBuilder
import com.practice.data.BuildConfig
import com.practice.data.api.ApiService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val URL = "http://api.themoviedb.org/3/"
private const val TIMEOUT = 10L

@Module
class ApiModule {

    @Provides
    fun providesRetrofitInstance() = Retrofit.Builder()
        .baseUrl(URL)
        .client(getHttpClient())
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .build()

    @Provides
    fun providesApiService() = providesRetrofitInstance().create(ApiService::class.java)

    private fun getHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) {
            interceptor.level = HttpLoggingInterceptor.Level.BODY
        } else {
            interceptor.level = HttpLoggingInterceptor.Level.NONE
        }
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT, TimeUnit.SECONDS)
            .build()
    }
}