package com.example.abdigitaltest.di

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.chuckerteam.chucker.api.RetentionManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object OkhttpModule {

    const val TIME_OUT = 60L

    @Provides
    @Singleton
    fun buildClient(
        @LoggingInterceptor interceptor: HttpLoggingInterceptor,
        chuckerInterceptor: ChuckerInterceptor
    ): OkHttpClient {
        val builder = OkHttpClient.Builder()
        builder
            .retryOnConnectionFailure(true)
            .addInterceptor(interceptor)
            .addInterceptor(chuckerInterceptor)
            .readTimeout(TIME_OUT, TimeUnit.SECONDS)
            .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
            .writeTimeout(TIME_OUT, TimeUnit.SECONDS)

        return builder.build()
    }


    @Provides
    @Singleton
    @LoggingInterceptor
    fun loggingInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
//        if (BuildConfig.DEBUG)
        logging.level = HttpLoggingInterceptor.Level.BODY
//        else logging.level = HttpLoggingInterceptor.Level.NONE
        return logging
    }

    @Provides
    @Singleton
    fun chuckProvide(@ApplicationContext context: Context): ChuckerInterceptor {
        val chuckerCollector = ChuckerCollector(
            context = context,
            showNotification = true,
            retentionPeriod = RetentionManager.Period.ONE_HOUR
        )

        return ChuckerInterceptor.Builder(context)
            .collector(chuckerCollector)
            .maxContentLength(250_000L)
            .redactHeaders("Auth-Token", "Bearer")
            .alwaysReadResponseBody(true)
            .build()
    }
}