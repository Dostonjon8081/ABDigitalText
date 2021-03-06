package com.example.abdigitaltest.core_fragment.home

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CharactersDto(
    val count: Int? ,
    val next: String?,
    val previous: String? ,
    val results: List<ResultCharacterDto>?
):Parcelable

@Parcelize
data class ResultCharacterDto(
    val name: String?,
    val height: String?,
    val mass: String?,
    val hair_color: String?,
    val skin_color: String?,
    val eye_color: String?,
    val birth_year: String?,
    val gender: String?,
    val homeworld: String?,
    val films: List<String>?,
    val species: List<String>?,
    val vehicles: List<String>?,
    val starships: List<String>?,
    val created: String?,
    val edited: String?,
    val url: String?
):Parcelable