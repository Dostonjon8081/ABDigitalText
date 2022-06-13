package com.example.abdigitaltest.util.local_db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Characters")
data class CharacterModel (@PrimaryKey val id :Long = 0)