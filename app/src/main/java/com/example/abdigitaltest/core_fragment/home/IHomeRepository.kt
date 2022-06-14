package com.example.abdigitaltest.core_fragment.home

import com.example.abdigitaltest.util.extension.any_logd
import com.example.abdigitaltest.util.extension.logd
import com.example.abdigitaltest.util.network.NetworkService
import javax.inject.Inject

interface IHomeRepository {
    suspend fun getCharacters()
}

class HomeRepositoryImpl @Inject constructor(
    private val networkService: NetworkService
) : IHomeRepository {
    override suspend fun getCharacters() {
        val networkResult = networkService.getCharacters()
        if (networkResult.isSuccessful) {
            val resultBody = networkResult.body()
            if (resultBody != null) {
                logd(resultBody!!.next!!)
                logd(resultBody.count.toString())
                any_logd(resultBody.previous?.toString()!!)
                logd(resultBody.results!![1].name)
                logd(resultBody.results[1].starships.toString())
            }
        }
    }
}