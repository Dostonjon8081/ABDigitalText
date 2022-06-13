package com.example.abdigitaltest.di

import com.example.abdigitaltest.core_fragment.home.HomeInteractorImpl
import com.example.abdigitaltest.core_fragment.home.IHomeInteractor
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import javax.inject.Singleton


@Module
@InstallIn(ViewModelComponent::class)
interface InteractorModule {

    @Binds
    fun mainInteractor(interactorImpl: HomeInteractorImpl): IHomeInteractor

}