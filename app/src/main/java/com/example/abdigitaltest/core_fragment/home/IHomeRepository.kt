package com.example.abdigitaltest.core_fragment.home

import android.util.Log
import com.example.abdigitaltest.util.network.NetworkService
import timber.log.Timber
import javax.inject.Inject

interface IHomeRepository{
    suspend fun getCharacters()
}

class HomeRepositoryImpl @Inject constructor(
    private val networkService: NetworkService
) : IHomeRepository {
    override suspend fun getCharacters() {
        Timber.log(0,"digitals" ,networkService.getCharacters())
        Log.d("digitals", networkService.getCharacters().toString())

    }
}