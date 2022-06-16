package com.example.abdigitaltest.core_fragment.favourite

import com.example.abdigitaltest.core_fragment.home.CharactersRvModel
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

interface IFavInteractor {
    suspend fun getCharacters(): List<CharactersRvModel>
    suspend fun deleteFav(name: String)
}

class FavInteractorImpl @Inject constructor(
    private val repository: IFavRepository
) : IFavInteractor {
    override suspend fun getCharacters(): List<CharactersRvModel> {
        val list = mutableListOf<CharactersRvModel>()
        repository.getCharacters().collect {
            list.clear()
            it.forEach { entity ->
                list.add(
                    CharactersRvModel(
                        entity.name,
                        entity.height,
                        entity.mass,
                        entity.hair_color,
                        entity.skin_color,
                        entity.eye_color,
                        entity.birth_year,
                        entity.gender,
                        entity.homeworld,
                        entity.films!!,
                        entity.species!!,
                        entity.vehicles!!,
                        entity.starships!!,
                        entity.created,
                        entity.edited,
                        entity.url
                    )
                )
            }
        }
        return list
    }


    override suspend fun deleteFav(name: String) {

        repository.deleteFav(name)
    }


}