package com.example.abdigitaltest.di

import com.example.abdigitaltest.core_fragment.home.HomeInteractorImpl
import com.example.abdigitaltest.core_fragment.home.IHomeInteractor
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
interface InteractorModule {

    @Binds
    fun mainInteractor(interactImpl: HomeInteractorImpl): IHomeInteractor

}