package com.example.abdigitaltest.core_fragment.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.abdigitaltest.R

class CharacterAdapter : RecyclerView.Adapter<CharacterAdapter.VH>() {

    private val list = mutableListOf<ResultCharacterDto>()
    private lateinit var click:IClickCharacterItem

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(
            LayoutInflater.from(parent.context).inflate(R.layout.character_rv_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(list[position],click)
    }

    override fun getItemCount(): Int = list.size

    fun initDat(list: List<ResultCharacterDto>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    fun initClick(iClickCharacterItem: IClickCharacterItem){
        click = iClickCharacterItem
    }

    class VH(val view: View) : RecyclerView.ViewHolder(view) {
        private val name = view.findViewById<TextView>(R.id.rv_item_name)
        private val height = view.findViewById<TextView>(R.id.rv_item_height)
        private val mass = view.findViewById<TextView>(R.id.rv_item_mass)
        private val hairColor = view.findViewById<TextView>(R.id.rv_item_hair_color)
        private val skinColor = view.findViewById<TextView>(R.id.rv_item_skin_color)
        private val eyeColor = view.findViewById<TextView>(R.id.rv_item_eye_color)
        private val birthColor = view.findViewById<TextView>(R.id.rv_item_birth_year)
        private val gender = view.findViewById<TextView>(R.id.rv_item_gender)
        private val homeWorld = view.findViewById<TextView>(R.id.rv_item_home_world)
        private val films = view.findViewById<TextView>(R.id.rv_item_films)
        private val species = view.findViewById<TextView>(R.id.rv_item_species)
        private val vehicles = view.findViewById<TextView>(R.id.rv_item_vehicles)
        private val startShip = view.findViewById<TextView>(R.id.rv_item_start_ship)
        private val created = view.findViewById<TextView>(R.id.rv_item_created)
        private val edited = view.findViewById<TextView>(R.id.rv_item_edited)
        private val url = view.findViewById<TextView>(R.id.rv_item_url)
        private val favBtn = view.findViewById<ImageView>(R.id.fav_btn)

        @SuppressLint("SetTextI18n")
        fun onBind(resultCharacterDto: ResultCharacterDto,iClickCharacterItem: IClickCharacterItem) {
            name.text = "name: ${resultCharacterDto.name}"
            height.text = "height: ${resultCharacterDto.height}"
            mass.text = "mass: ${resultCharacterDto.mass}"
            hairColor.text = "herColor: ${resultCharacterDto.hair_color}"
            skinColor.text = "skinColor: ${resultCharacterDto.skin_color}"
            eyeColor.text = "eyeColor: ${resultCharacterDto.eye_color}"
            birthColor.text = "birthYear: ${resultCharacterDto.birth_year}"
            gender.text = "gender: ${resultCharacterDto.gender}"
            homeWorld.text = "homeWorld: ${resultCharacterDto.homeworld}"
            films.text = "films: ${resultCharacterDto.films.toString()}"
            species.text = "species: ${resultCharacterDto.species.toString()}"
            vehicles.text = "vehicles: ${resultCharacterDto.vehicles.toString()}"
            startShip.text = "startShip: ${resultCharacterDto.starships}"
            created.text = "created: ${resultCharacterDto.created}"
            edited.text = "edited: ${resultCharacterDto.edited}"
            url.text = "url: ${resultCharacterDto.url}"
            favBtn.setOnClickListener { iClickCharacterItem.clickedItem(resultCharacterDto) }
        }
    }
}