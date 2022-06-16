package com.example.abdigitaltest.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import timber.log.Timber
import java.io.IOException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.inject.Inject

abstract class BaseViewModel : ViewModel() {
    val loading: MutableLiveData<Boolean> = MutableLiveData()
    val handler = CoroutineExceptionHandler { _, exception ->
        Timber.d("errorProcess - $exception")
    }

    val vmScope = viewModelScope + handler + Dispatchers.IO
}