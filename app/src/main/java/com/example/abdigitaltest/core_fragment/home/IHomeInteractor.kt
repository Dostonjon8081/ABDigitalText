package com.example.abdigitaltest.core_fragment.home

import javax.inject.Inject

interface IHomeInteractor {
    suspend fun getCharacters()
    suspend fun searchCharacter(name:String)
}

class HomeInteractorImpl @Inject constructor(
    private val repository: IHomeRepository
) : IHomeInteractor {
    override suspend fun getCharacters() {
        repository.getCharacters()
    }

    override suspend fun searchCharacter(name: String) {
        repository.searchCharacters(name)
    }

}