package com.example.abdigitaltest.core_fragment.home

import javax.inject.Inject

interface IHomeInteractor {
    suspend fun getCharacters()
}

class HomeInteractorImpl @Inject constructor(
    private val repository: IHomeRepository
) : IHomeInteractor {
    override suspend fun getCharacters() {
        repository.getCharacters()
    }

}