package com.example.abdigitaltest.core_fragment.home

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

//    private val _charachtersResponseApi:MutableLiveData<Event<NetworkResult<CharactersResponseModel>>> = MutableLiveData()
//       val charactersResponseApi:LiveData<Event<NetworkResult<CharactersResponseModel>>> = _charachtersResponseApi

    private fun getCharacters(){
        vmScope.launch {
            loading.postValue(true)
            interactor.getCharacters()
        }.invokeOnCompletion {
            loading.postValue(false)
        }
    }
}