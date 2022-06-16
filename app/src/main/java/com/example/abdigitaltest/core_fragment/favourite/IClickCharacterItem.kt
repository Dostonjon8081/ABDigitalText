package com.example.abdigitaltest.core_fragment.favourite

import com.example.abdigitaltest.core_fragment.home.CharactersRvModel

interface IClickFavItem {
     fun clickedItem(model: CharactersRvModel)

     fun deleteFav(name:String)}