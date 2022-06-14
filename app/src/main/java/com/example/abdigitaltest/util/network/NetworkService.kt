package com.example.abdigitaltest.util.network

import com.example.abdigitaltest.core_fragment.home.CharactersResponseModel
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface NetworkService {

//    @GET("people/")
//    suspend fun searchCharacter(@Query("search") name:String): Response<*>

    @GET("people")
    suspend fun getCharacters():Response<CharactersResponseModel>

    @GET("people/")
    suspend fun searchCharacter(@Query("search") name:String):Response<CharactersResponseModel>

}