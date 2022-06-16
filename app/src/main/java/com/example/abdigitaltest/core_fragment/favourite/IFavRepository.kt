package com.example.abdigitaltest.core_fragment.favourite

import com.example.abdigitaltest.util.local_db.ABDigitalDataBase
import com.example.abdigitaltest.util.local_db.CharacterEntity
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

interface IFavRepository {
    suspend fun getCharacters(): Flow<List<CharacterEntity>>
    suspend fun deleteFav(name: String)
}

class FavRepositoryImpl @Inject constructor(
    private val abDigitalDataBase: ABDigitalDataBase
) : IFavRepository {

    private val dbService = abDigitalDataBase.dbService()

    override suspend fun getCharacters(): Flow<List<CharacterEntity>> {
        return flow {
            emit(abDigitalDataBase.dbService().getAll())
        }.flowOn(IO)
    }


    override suspend fun deleteFav(name: String) {
        dbService.deleteFav(name)
    }


}