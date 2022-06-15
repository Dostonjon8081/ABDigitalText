package com.example.abdigitaltest.core_fragment.home

import com.example.abdigitaltest.util.network.BaseApiResponse
import com.example.abdigitaltest.util.network.NetworkResult
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

interface IHomeInteractor {
    suspend fun getCharacters(): CharactersDto
    suspend fun searchCharacter(name: String): CharactersDto
}

class HomeInteractorImpl @Inject constructor(
    private val repository: IHomeRepository
) : IHomeInteractor, BaseApiResponse() {
    override suspend fun getCharacters(): CharactersDto {
        var charactersDto: CharactersDto? = null
        repository.getCharacters().collect {
            when (it) {
                is NetworkResult.Success -> charactersDto = it.data!!
                is NetworkResult.Error -> {}
                is NetworkResult.Loading -> {}
            }
        }
        return charactersDto!!
    }

    override suspend fun searchCharacter(name: String): CharactersDto {
        var charactersDto: CharactersDto? = null

        repository.searchCharacters(name).collect {
            when (it) {
                is NetworkResult.Success -> charactersDto = it.data!!
                is NetworkResult.Error -> {}
                is NetworkResult.Loading -> {}
            }
        }
        return charactersDto!!
    }

}