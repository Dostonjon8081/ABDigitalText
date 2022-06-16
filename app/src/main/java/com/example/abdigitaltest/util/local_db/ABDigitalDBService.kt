package com.example.abdigitaltest.util.local_db

import androidx.room.*

@Dao
interface ABDigitalDBService {
    @Query("SELECT * FROM CHARACTER")
    suspend fun getAll(): List<CharacterEntity>

    @Query("DELETE FROM CHARACTER WHERE name=:name")
    suspend fun deleteFav(name: String)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addFav(vararg modelEntity: CharacterEntity)


}