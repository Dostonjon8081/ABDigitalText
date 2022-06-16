package com.example.abdigitaltest.core_fragment.home

interface IClickCharacterItem {
    fun clickedItem(model: CharactersRvModel)
    fun addFav(model: CharactersRvModel)
    fun deleteFav(model: CharactersRvModel)
}