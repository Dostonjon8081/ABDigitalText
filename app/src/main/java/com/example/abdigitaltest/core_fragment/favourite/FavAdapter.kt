package com.example.abdigitaltest.core_fragment.favourite

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.abdigitaltest.R
import com.example.abdigitaltest.core_fragment.home.CharactersRvModel
import com.example.abdigitaltest.databinding.CharacterRvItemBinding
import com.example.abdigitaltest.databinding.FavRvItemBinding

class FavAdapter : RecyclerView.Adapter<FavAdapter.VH>() {

    private val list = mutableListOf<CharactersRvModel>()
    private lateinit var click: IClickFavItem

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {

        val binding =
            FavRvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VH(binding, click)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun initData(list: List<CharactersRvModel>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    fun initClick(iClickFavItem: IClickFavItem) {
        click = iClickFavItem
    }

    class VH(
        private val binding: FavRvItemBinding,
        private val iClickFavItem: IClickFavItem
    ) : RecyclerView.ViewHolder(binding.root) {

        private lateinit var model: CharactersRvModel

        init {
            binding.root.setOnClickListener { iClickFavItem.clickedItem(model) }

            binding.favBtn.setOnClickListener {
                iClickFavItem.deleteFav(model.name)
                model.isFavourite = false
            }
        }

        @SuppressLint("SetTextI18n")
        fun onBind(charactersRvModel: CharactersRvModel) {
            model = charactersRvModel
            binding.rvItemName.text = "name: ${model.name}"
            binding.rvItemHeight.text = "height: ${model.height}"
            binding.rvItemMass.text = "mass: ${model.mass}"
            binding.rvItemHairColor.text = "hairColor: ${model.hair_color}"
            binding.rvItemSkinColor.text = "skinColor: ${model.skin_color}"
            binding.rvItemEyeColor.text = "eyeColor: ${model.eye_color}"
            binding.rvItemBirthYear.text = "birthYear: ${model.birth_year}"
            binding.rvItemGender.text = "gender: ${model.gender}"
        }
    }
}