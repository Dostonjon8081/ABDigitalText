package com.example.abdigitaltest.core_fragment.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.abdigitaltest.R
import com.example.abdigitaltest.databinding.CharacterRvItemBinding

class CharacterAdapter : RecyclerView.Adapter<CharacterAdapter.VH>() {

    private val list = mutableListOf<CharactersRvModel>()
    private lateinit var click: IClickCharacterItem

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {

        val binding =
            CharacterRvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VH(binding, click)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun initDat(list: List<CharactersRvModel>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    fun initClick(iClickCharacterItem: IClickCharacterItem) {
        click = iClickCharacterItem
    }

    class VH(
        private val binding: CharacterRvItemBinding,
        private val iClickCharacterItem: IClickCharacterItem
    ) : RecyclerView.ViewHolder(binding.root) {

        private lateinit var model: CharactersRvModel

        init {
            binding.favBtn.setOnClickListener {
                if (!model.isFavourite) {
                    binding.favBtn.setImageResource(R.drawable.ic_fav)
                    iClickCharacterItem.clickedItem(model)
                    model.isFavourite = true
                } else {
                    binding.favBtn.setImageResource(R.drawable.ic_fav_empty)
                    iClickCharacterItem.clickedItem(model)
                    model.isFavourite = false
                }
            }
        }

        @SuppressLint("SetTextI18n")
        fun onBind(
            charactersRvModel: CharactersRvModel,
        ) {
            model = charactersRvModel
            binding.rvItemName.text = "name: ${model.name}"
            binding.rvItemHeight.text = "height: ${model.height}"
            binding.rvItemMass.text = "mass: ${model.mass}"
            binding.rvItemHairColor.text = "herColor: ${model.hair_color}"
            binding.rvItemSkinColor.text = "skinColor: ${model.skin_color}"
            binding.rvItemEyeColor.text = "eyeColor: ${model.eye_color}"
            binding.rvItemBirthYear.text = "birthYear: ${model.birth_year}"
            binding.rvItemGender.text = "gender: ${model.gender}"
            binding.rvItemHomeWorld.text = "homeWorld: ${model.homeworld}"
            binding.rvItemFilms.text = "films: ${model.films.toString()}"
            binding.rvItemSpecies.text = "species: ${model.species.toString()}"
            binding.rvItemVehicles.text = "vehicles: ${model.vehicles.toString()}"
            binding.rvItemStartShip.text = "startShip: ${model.starships}"
            binding.rvItemCreated.text = "created: ${model.created}"
            binding.rvItemEdited.text = "edited: ${model.edited}"
            binding.rvItemUrl.text = "url: ${model.url}"
        }
    }
}