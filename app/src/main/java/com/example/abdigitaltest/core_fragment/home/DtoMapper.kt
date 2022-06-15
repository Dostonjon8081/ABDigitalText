package com.example.abdigitaltest.core_fragment.home

import com.example.abdigitaltest.util.extension.logd

//object DtoMapper {
//
//    fun charactersDtoToModel(dto: CharactersDto): CharactersModel {
//
//        val resultCharacter = resultsDtoToModel(dto.results!!)
//
//        val characterModel = CharactersModel(dto.count!!, dto.next!!, dto.previous, resultCharacter)
//
//        logd(characterModel.count.toString())
//        return characterModel
//    }
//
//    private fun resultsDtoToModel(listDto: List<ResultCharacterDto>): List<ResultCharacter> {
//
//        val listResultCharacter = mutableListOf<ResultCharacter>()
//        listDto.map {
//            listResultCharacter.add(
//                ResultCharacter(
//                    it.name!!,
//                    it.height!!,
//                    it.mass!!,
//                    it.hair_color!!,
//                    it.skin_color!!,
//                    it.eye_color!!,
//                    it.birth_year!!,
//                    it.gender!!,
//                    it.homeworld!!,
//                    it.films!!,
//                    it.species!!,
//                    it.vehicles!!,
//                    it.starships!!,
//                    it.created!!,
//                    it.edited!!,
//                    it.url!!
//                )
//            )
//        }
//        return listResultCharacter
//    }
//}
interface Mapper<From, To> {
    fun map(value: From): To
}

class DtoMapper :Mapper<CharactersDto,CharactersModel> {
    override fun map(value: CharactersDto): CharactersModel {
        val resultCharacter = resultsDtoToModel(value.results!!)
//
        val characterModel = CharactersModel(value.count!!, value.next!!, value.previous, resultCharacter)

        logd(characterModel.count.toString())
        return characterModel
    }


    private fun resultsDtoToModel(listDto: List<ResultCharacterDto>): List<ResultCharacter> {

        val listResultCharacter = mutableListOf<ResultCharacter>()
        listDto.map {
            listResultCharacter.add(
                ResultCharacter(
                    it.name!!,
                    it.height!!,
                    it.mass!!,
                    it.hair_color!!,
                    it.skin_color!!,
                    it.eye_color!!,
                    it.birth_year!!,
                    it.gender!!,
                    it.homeworld!!,
                    it.films!!,
                    it.species!!,
                    it.vehicles!!,
                    it.starships!!,
                    it.created!!,
                    it.edited!!,
                    it.url!!
                )
            )
        }
        return listResultCharacter
    }
}