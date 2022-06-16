package com.example.abdigitaltest.core_fragment.home

import com.example.abdigitaltest.util.local_db.CharacterEntity
import com.example.abdigitaltest.util.network.BaseApiResponse
import com.example.abdigitaltest.util.network.NetworkResult
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

interface IHomeInteractor {
    suspend fun getCharacters(): List<CharactersRvModel>
    suspend fun searchCharacter(name: String): List<CharactersRvModel>
    suspend fun deleteFav(model: CharactersRvModel)
    suspend fun addFav(model: CharactersRvModel)
}

class HomeInteractorImpl @Inject constructor(
    private val repository: IHomeRepository
) : IHomeInteractor{
    override suspend fun getCharacters(): List<CharactersRvModel> {
        val list = mutableListOf<CharactersRvModel>()
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
        val list = mutableListOf<CharactersRvModel>()
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

    override suspend fun deleteFav(model: CharactersRvModel) {

        repository.deleteFav(
            CharacterEntity(
                model.name,
                model.height,
                model.mass,
                model.hair_color,
                model.skin_color,
                model.eye_color,
                model.birth_year,
                model.gender,
                model.homeworld,
                model.films,
                model.species,
                model.vehicles,
                model.starships,
                model.created,
                model.edited,
                model.url,
                model.isFavourite
            )
        )
    }

    override suspend fun addFav(model: CharactersRvModel) {
        repository.addFav( CharacterEntity(
             model.name,
            model.height,
            model.mass,
            model.hair_color,
            model.skin_color,
            model.eye_color,
            model.birth_year,
            model.gender,
            model.homeworld,
            model.films,
            model.species,
            model.vehicles,
            model.starships,
            model.created,
            model.edited,
            model.url,
            model.isFavourite
        ))
    }

}