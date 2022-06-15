package com.example.abdigitaltest.util.local_db

import androidx.room.Dao
import androidx.room.Query

@Dao
interface ABDigitalDBService {
    @Query("SELECT * FROM CHARACTER")
    suspend fun getAll(): List<CharacterEntity>




}