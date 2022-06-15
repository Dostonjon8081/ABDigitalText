package com.example.abdigitaltest.core_fragment.home

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CharactersRvModel(
    val name: String="",
    val height: String="",
    val mass: String="",
    val hair_color: String="",
    val skin_color: String="",
    val eye_color: String="",
    val birth_year: String="",
    val gender: String="",
    val homeworld: String="",
    val films: List<String?>,
    val species: List<String?>,
    val vehicles: List<String?>,
    val starships: List<String?>,
    val created: String,
    val edited: String,
    val url: String,
    var isFavourite:Boolean = false
    ):Parcelable