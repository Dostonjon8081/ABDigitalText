package com.example.abdigitaltest.util.local_db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Characters")
data class CharacterEntity(
    @PrimaryKey val id: Long = 0,
    @ColumnInfo(name = "count") val count: Int?,
//    @ColumnInfo(name = "results") val results: List<ResultCharacterEntity>?
    )

//@Entity
//data class ResultCharacterEntity(
//    val name: String = "",
//    val height: String = "",
//    val mass: String = "",
//    val hair_color: String = "",
//    val skin_color: String = "",
//    val eye_color: String = "",
//    val birth_year: String = "",
//    val gender: String = "",
//    val homeworld: String = "",
//    val films: List<String?>,
//    val species: List<String?>,
//    val vehicles: List<String?>,
//    val starships: List<String?>,
//    val created: String,
//    val edited: String,
//    val url: String
//)