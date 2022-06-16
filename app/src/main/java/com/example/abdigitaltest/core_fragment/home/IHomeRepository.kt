package com.example.abdigitaltest.core_fragment.home

import com.example.abdigitaltest.util.local_db.ABDigitalDataBase
import com.example.abdigitaltest.util.local_db.CharacterEntity
import com.example.abdigitaltest.util.network.BaseApiResponse
import com.example.abdigitaltest.util.network.NetworkResult
import com.example.abdigitaltest.util.network.NetworkService
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

interface IHomeRepository {
    suspend fun getCharacters(): Flow<NetworkResult<CharactersDto>>
    suspend fun searchCharacters(name: String): Flow<NetworkResult<CharactersDto>>
    suspend fun deleteFav(modelEntity: CharacterEntity)
    suspend fun addFav(modelEntity: CharacterEntity)
}

class HomeRepositoryImpl @Inject constructor(
    private val networkService: NetworkService,
    private val abDigitalDataBase: ABDigitalDataBase
) : IHomeRepository, BaseApiResponse() {

    private val dbService = abDigitalDataBase.dbService()

    override suspend fun getCharacters(): Flow<NetworkResult<CharactersDto>> {
        return flow {
            emit(safeApiCall {
                networkService.getCharacters()
            })
        }.flowOn(IO)
    }

    override suspend fun searchCharacters(name: String): Flow<NetworkResult<CharactersDto>> {
        return flow {
            emit(safeApiCall {
                networkService.searchCharacter(name)
            })
        }.flowOn(IO)

    }

    override suspend fun deleteFav(modelEntity: CharacterEntity) {
        dbService.deleteFav(modelEntity.name)
    }

    override suspend fun addFav(modelEntity: CharacterEntity) {
        dbService.addFav(modelEntity)
    }


}