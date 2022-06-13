package com.example.abdigitaltest.util.network

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkService {

//    @GET("people/")
//    suspend fun searchCharacter(@Query("search") name:String): Response<*>

    @GET("people")
    suspend fun getCharacters():ResponseBody
}