package com.example.abdigitaltest

import android.app.Application
import androidx.multidex.BuildConfig
import androidx.multidex.MultiDexApplication
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class ABDigitalTestApplication : MultiDexApplication()