package com.example.abdigitaltest.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.scopes.ActivityScoped
import com.example.abdigitaltest.util.network.ConnectionLiveData


@Module
@InstallIn(ActivityComponent::class)
object ActivityModule {

    @ActivityScoped
    @Provides
    fun getConnectionLiveData(@ActivityContext context: Context): ConnectionLiveData =
        ConnectionLiveData(context)

}