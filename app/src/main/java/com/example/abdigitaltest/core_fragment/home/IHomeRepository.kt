package com.example.abdigitaltest.core_fragment.home

import com.example.abdigitaltest.util.extension.logd
import com.example.abdigitaltest.util.local_db.ABDigitalDBService
import com.example.abdigitaltest.util.local_db.ABDigitalDataBase
import com.example.abdigitaltest.util.network.NetworkService
import javax.inject.Inject

interface IHomeRepository {
    suspend fun getCharacters()
    suspend fun searchCharacters(name: String)
}

class HomeRepositoryImpl @Inject constructor(
    private val networkService: NetworkService,
    private val abDigitalDataBase: ABDigitalDataBase
) : IHomeRepository {

    private val dbService = abDigitalDataBase.dbService()

    override suspend fun getCharacters() {
        val networkResult = networkService.getCharacters()
        if (networkResult.isSuccessful) {
            val resultBody = networkResult.body()
            if (resultBody != null) {

            }
        }
    }

    override suspend fun searchCharacters(name: String) {
        val networkResult = networkService.searchCharacter("Luke Skywalker")

        if (networkResult.isSuccessful) {
            val resultBody = networkResult.body()
            if (resultBody != null) {
                val model = DtoMapper.map(resultBody)

                logd(model.toString())
            }
        }

    }


}