package com.example.abdigitaltest.core_fragment.home

import com.example.abdigitaltest.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
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

    fun getCharacters(){
        vmScope.launch {
            interactor.getCharacters()
        }
    }
}