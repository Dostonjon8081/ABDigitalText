package com.example.abdigitaltest.di

import android.content.Context
import android.nfc.Tag
import androidx.lifecycle.MutableLiveData
import androidx.multidex.BuildConfig

import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun getPreference(@ApplicationContext context: Context): SharedPreferences =
        context.getSharedPreferences(
            "ABDigital", Context.MODE_PRIVATE
        )


}