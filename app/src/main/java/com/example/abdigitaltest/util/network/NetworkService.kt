package com.example.abdigitaltest.util.network

import com.example.abdigitaltest.core_fragment.home.CharactersDto
import com.example.abdigitaltest.core_fragment.home.CharactersModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkService {

//    @GET("people/")
//    suspend fun searchCharacter(@Query("search") name:String): Response<*>

    @GET("people")
    suspend fun getCharacters():Response<CharactersDto>

    @GET("people/")
    suspend fun searchCharacter(@Query("search") name:String):Response<CharactersDto>

}