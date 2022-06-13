package com.example.abdigitaltest.di

import android.content.Context
import androidx.room.Room
import com.example.abdigitaltest.util.local_db.ABDigitalDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalDatabaseModule {

    @Provides
    @Singleton
    fun getDatabase(@ApplicationContext context: Context): ABDigitalDataBase =
        Room.databaseBuilder(
            context,
            ABDigitalDataBase::class.java,
            "ABDigitalDB"
        )
            .fallbackToDestructiveMigration()
            .build()

}