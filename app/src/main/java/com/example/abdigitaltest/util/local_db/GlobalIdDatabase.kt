package com.example.abdigitaltest.util.local_db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        CharacterEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class ABDigitalDataBase : RoomDatabase() {
    abstract fun dbService(): ABDigitalDBService

}