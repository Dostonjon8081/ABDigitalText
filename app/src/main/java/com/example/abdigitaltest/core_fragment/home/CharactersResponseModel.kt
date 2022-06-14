package com.example.abdigitaltest.core_fragment.home

import com.google.gson.annotations.SerializedName


data class CharactersResponseModel(
    val count: Int=0,
    val next: String="",
    val previous: String?="previous",
    val results: List<ResultCharacter>?
)


data class ResultCharacter(
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
    val url: String
    )