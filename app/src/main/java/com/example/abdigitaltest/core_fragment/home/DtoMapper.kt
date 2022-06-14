package com.example.abdigitaltest.core_fragment.home

import dagger.Component

@Component
class DtoMapper {

    fun entityToDto(charactersResponseModel: CharactersResponseModel): CharactersDto {
        return CharactersDto(charactersResponseModel.count, charactersResponseModel.next, charactersResponseModel.previous,charactersResponseModel.results.map {

        })
    }
}