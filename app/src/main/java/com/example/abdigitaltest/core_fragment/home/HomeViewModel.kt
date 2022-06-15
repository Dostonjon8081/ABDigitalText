package com.example.abdigitaltest.core_fragment.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.abdigitaltest.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val interactor: IHomeInteractor
) : BaseViewModel() {

    init {
        Timber.d("viewmodel created")
        getCharacters()

    }

    private val _charactersResponseApi: MutableLiveData<List<CharactersRvModel>> = MutableLiveData()
    val charactersResponseApi: LiveData<List<CharactersRvModel>> = _charactersResponseApi

    fun getCharacters() {
        vmScope.launch {
            loading.postValue(true)
            _charactersResponseApi.postValue(interactor.getCharacters())
        }.invokeOnCompletion {
            loading.postValue(false)
        }
    }

    private val _searchCharacter: MutableLiveData<List<CharactersRvModel>> = MutableLiveData()
    val searchCharacter: LiveData<List<CharactersRvModel>> = _searchCharacter
    fun searchCharacter(name: String) {
        vmScope.launch {
            loading.postValue(true)
            _searchCharacter.postValue(interactor.searchCharacter(name))
        }.invokeOnCompletion {
            loading.postValue(false)
        }
    }
}