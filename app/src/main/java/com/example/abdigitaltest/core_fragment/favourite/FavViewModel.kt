package com.example.abdigitaltest.core_fragment.favourite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.abdigitaltest.base.BaseViewModel
import com.example.abdigitaltest.core_fragment.home.CharactersRvModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavViewModel @Inject constructor(
    private val interactor: IFavInteractor
) : BaseViewModel() {


    private val _getCharacters: MutableLiveData<List<CharactersRvModel>> = MutableLiveData()
    val getCharacters: LiveData<List<CharactersRvModel>> = _getCharacters
     fun getCharacters() {
        vmScope.launch {
            loading.postValue(true)
            _getCharacters.postValue(interactor.getCharacters())
        }.invokeOnCompletion {
            loading.postValue(false)
        }
    }

    fun deleteFav(name: String) {
        vmScope.launch {
            interactor.deleteFav(name)
            getCharacters()
        }
    }

}