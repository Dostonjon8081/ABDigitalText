package com.example.abdigitaltest.core_fragment.home

import com.example.abdigitaltest.util.network.BaseApiResponse
import com.example.abdigitaltest.util.network.NetworkResult
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

interface IHomeInteractor {
    suspend fun getCharacters(): List<CharactersRvModel>
    suspend fun searchCharacter(name: String): List<CharactersRvModel>
}

class HomeInteractorImpl @Inject constructor(
    private val repository: IHomeRepository
) : IHomeInteractor, BaseApiResponse() {
    override suspend fun getCharacters(): List<CharactersRvModel> {
        var list = mutableListOf<CharactersRvModel>()
        repository.getCharacters().collect {
            list.clear()
            when (it) {
                is NetworkResult.Success -> {
                    it.data!!.results?.forEach { dto ->
                        list.add(
                            CharactersRvModel(
                                dto.name!!,
                                dto.height!!,
                                dto.mass!!,
                                dto.hair_color!!,
                                dto.skin_color!!,
                                dto.eye_color!!,
                                dto.birth_year!!,
                                dto.gender!!,
                                dto.homeworld!!,
                                dto.films!!,
                                dto.species!!,
                                dto.vehicles!!,
                                dto.starships!!,
                                dto.created!!,
                                dto.edited!!,
                                dto.url!!
                            )
                        )
                    }
                }
                is NetworkResult.Error -> {}
                is NetworkResult.Loading -> {}
            }
        }
        return list
    }

    override suspend fun searchCharacter(name: String): List<CharactersRvModel> {
        var list = mutableListOf<CharactersRvModel>()
        repository.searchCharacters(name).collect {
            list.clear()
            when (it) {
                is NetworkResult.Success -> {
                    it.data!!.results?.forEach { dto ->
                        list.add(
                            CharactersRvModel(
                                dto.name!!,
                                dto.height!!,
                                dto.mass!!,
                                dto.hair_color!!,
                                dto.skin_color!!,
                                dto.eye_color!!,
                                dto.birth_year!!,
                                dto.gender!!,
                                dto.homeworld!!,
                                dto.films!!,
                                dto.species!!,
                                dto.vehicles!!,
                                dto.starships!!,
                                dto.created!!,
                                dto.edited!!,
                                dto.url!!
                            )
                        )
                    }
                }
                is NetworkResult.Error -> {}
                is NetworkResult.Loading -> {}
            }
        }
        return list
    }

}