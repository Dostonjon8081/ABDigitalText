package com.example.abdigitaltest.di

import com.example.abdigitaltest.util.network.NetworkService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit


@Module
@InstallIn(SingletonComponent::class)
class ApiServiceModule {

//    @Provides
//    fun getAuthHttpService(retrofit: Retrofit): NetworkService =
//        retrofit.create(NetworkService::class.java)
}