package com.example.abdigitaltest.util.local_db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Character")
data class CharacterEntity(
    val name: String = "",
    val height: String = "",
    val mass: String = "",
    val hair_color: String = "",
    val skin_color: String = "",
    val eye_color: String = "",
    val birth_year: String = "",
    val gender: String = "",
    val homeworld: String = "",
    val films: List<String>? = listOf(),
    val species: List<String>? = listOf(),
    val vehicles: List<String>? = listOf(),
    val starships: List<String>?= listOf(),
    val created: String,
    val edited: String,
    val url: String,
    var isFavourite:Boolean = false,
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
)