package com.example.abdigitaltest.di

import com.example.abdigitaltest.core_fragment.favourite.FavRepositoryImpl
import com.example.abdigitaltest.core_fragment.favourite.IFavRepository
import com.example.abdigitaltest.core_fragment.home.HomeRepositoryImpl
import com.example.abdigitaltest.core_fragment.home.IHomeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
interface RepositoryModule {


    @Binds
    fun getMainRepository(repository: HomeRepositoryImpl): IHomeRepository

    @Binds
    fun getFavRepository(repository: FavRepositoryImpl):IFavRepository

}