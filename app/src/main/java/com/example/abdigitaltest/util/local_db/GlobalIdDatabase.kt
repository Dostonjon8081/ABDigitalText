package com.example.abdigitaltest.util.local_db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [
        CharacterEntity::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class ABDigitalDataBase : RoomDatabase() {
    abstract fun dbService(): ABDigitalDBService

}